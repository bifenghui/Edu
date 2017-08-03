package com.sibei.edu.home;

import android.content.Context;
import android.util.Log;

import com.sibei.edu.home.bean.HomeBean;
import com.sibei.edu.http.ServiceGenerator;
import com.sibei.edu.http.client.HomeClient;
import com.sibei.edu.http.constants.JValue;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/19
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:HomeFragment业务层逻辑实现
 */


public class HomeFragmentPresenterImp implements HomeFragmentPresenter{
    private static final String TAG = "HomeFragmentPresenterIm";

    private HomeFragmentView homeFragmentView;

    public HomeFragmentPresenterImp(HomeFragmentView homeFragmentView) {
        this.homeFragmentView = homeFragmentView;
    }

    @Override
    public void getHomeData() {
        HomeClient homeClient = ServiceGenerator.creatService(HomeClient.class);
        Call<HomeBean> homeCall = homeClient.getHomeData();
        homeCall.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                if(response.isSuccessful()){
                    HomeBean body = response.body();
                    if(body.getResult().equals(JValue.SUCCESS)){
                        homeFragmentView.fetchDataToBanner(body.getInfo().getPpt_list());
                        homeFragmentView.fetchDataToExpandView(body.getInfo().getClass_list());
                    }
                }
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void getCourseId(int groupPosition, int childPosition) {
        homeFragmentView.goToCourseListActivity(groupPosition,childPosition);
    }
}
