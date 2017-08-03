package com.sibei.edu.http.client;

import com.google.gson.JsonObject;
import com.sibei.edu.http.bean.LoginBean;
import com.sibei.edu.login.bean.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/14
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:客户端登录模块的请求接口
 */


public interface LoginClient {

    //登录接口
    @FormUrlEncoded
    @POST("/api.php/Public/login_json")
    Call<User> login(@Field("phone") String phone,@Field("code") String code);

    //获取验证码接口
    @FormUrlEncoded
    @POST("/api.php/Public/send_sms_json")
    Call<JsonObject> getCode(@Field("phone") String phone);

}
