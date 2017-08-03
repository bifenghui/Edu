package com.sibei.edu.home.presenter.presenterImp;

import com.sibei.edu.home.view.CourseListView;
import com.sibei.edu.home.bean.CourseBean;
import com.sibei.edu.home.presenter.CourseListPresenter;
import com.sibei.edu.http.ServiceGenerator;
import com.sibei.edu.http.client.HomeClient;
import com.sibei.edu.http.constants.JValue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/20
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:请求课程列表实现类
 */


public class CourseListPresenterImp implements CourseListPresenter {

    private HomeClient homeClient;
    private CourseListView courseListView;
    private int page = 1;

    public CourseListPresenterImp(CourseListView courseListView) {
        this.courseListView = courseListView;
    }

    @Override
    public void getCourseListData(String class_id) {
        if(courseListView!=null){
            courseListView.showProgress();
        }
        homeClient = ServiceGenerator.creatService(HomeClient.class);
        Call<CourseBean> courseList = homeClient.getCourseList(class_id, 1, 10);
        courseList.enqueue(new Callback<CourseBean>() {
            @Override
            public void onResponse(Call<CourseBean> call, Response<CourseBean> response) {
                if(response.isSuccessful()){
                    if(courseListView!=null){
                        courseListView.hideProgress();
                    }
                    CourseBean courseBean = response.body();
                    if(courseBean.getResult().equals(JValue.SUCCESS)){
                        if(courseListView!=null){
                            courseListView.showListData(courseBean);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CourseBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void refresh(String class_id) {
        page = 1;
        requestData(1,class_id);
    }

    @Override
    public void loadMore(String class_id) {
        page++;
        requestData(page,class_id);
    }

    private void requestData(final int page, String class_id){
        Call<CourseBean> courseList = homeClient.getCourseList(class_id, page, 10);
        courseList.enqueue(new Callback<CourseBean>() {
            @Override
            public void onResponse(Call<CourseBean> call, Response<CourseBean> response) {
                if(response.isSuccessful()){
                    if(courseListView!=null){
                        courseListView.refreshComplete();
                    }
                    CourseBean courseBean = response.body();
                    if(courseBean.getResult().equals(JValue.SUCCESS)){
                        if(courseListView!=null){
                            if(page==1){
                                courseListView.refreshData(courseBean);
                            }else {
                                courseListView.loadData(courseBean);
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<CourseBean> call, Throwable t) {

            }
        });
    }
}
