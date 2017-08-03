package com.sibei.edu.home.presenter.presenterImp;

import com.sibei.edu.home.bean.CourseBean;
import com.sibei.edu.home.bean.VideoDetailsBean;
import com.sibei.edu.home.presenter.VideoDetailPresenter;
import com.sibei.edu.home.view.VideoDetailView;
import com.sibei.edu.http.ServiceGenerator;
import com.sibei.edu.http.client.HomeClient;
import com.sibei.edu.http.constants.JValue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/21
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:视频详情业务层实现逻辑接口
 */


public class VideoDetailPresenterImp implements VideoDetailPresenter{

    private VideoDetailView videoDetailView;

    public VideoDetailPresenterImp(VideoDetailView videoDetailView) {
        this.videoDetailView = videoDetailView;
    }

    @Override
    public void requestData(String id) {
        HomeClient homeClient = ServiceGenerator.creatService(HomeClient.class);
        Call<VideoDetailsBean> videoDetail = homeClient.getVideoDetail(id);
        videoDetail.enqueue(new Callback<VideoDetailsBean>() {
            @Override
            public void onResponse(Call<VideoDetailsBean> call, Response<VideoDetailsBean> response) {
                if(response.isSuccessful()){
                    VideoDetailsBean videoDetailsBean = response.body();
                    if(videoDetailsBean.getResult().equals(JValue.SUCCESS)){
                        VideoDetailsBean.InfoBean.CourseInfoBean course_info = videoDetailsBean.getInfo().getCourse_info();
                        if(videoDetailView!=null){
                            videoDetailView.setVideoUrl(course_info.getVideo_url());
                            videoDetailView.fillData(course_info.getName(),
                                    course_info.getClass_name()+"/"+course_info.getLecturer_from()+"/"+course_info.getLecturer_name()
                            ,course_info.getContent());
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<VideoDetailsBean> call, Throwable t) {

            }
        });
    }
}
