package com.sibei.edu.http.client;

import com.sibei.edu.home.bean.CourseBean;
import com.sibei.edu.home.bean.HomeBean;
import com.sibei.edu.home.bean.VideoDetailsBean;
import com.sibei.edu.http.ServiceGenerator;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/19
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:首页客户端接口
 */


public interface HomeClient {

    //获取首页数据
    @GET("/api.php/Index/index_json")
    Call<HomeBean> getHomeData();

    //获取课程列表数据
    @FormUrlEncoded
    @POST("/api.php/Index/video_list_json")
    Call<CourseBean> getCourseList(
            @Field("class_id")
            String class_id,
            @Field("page")
            int page,
            @Field("page_count")
            int page_count
    );

    //获取课程详情接口
    @GET("api.php/Index/video_info_json")
    Call<VideoDetailsBean> getVideoDetail(@Query("video_id") String video_id);

}
