package com.sibei.edu.http;

import com.sibei.edu.http.constants.Host;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/14
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:创建网络核心请求类
 */


public class ServiceGenerator {

    private static OkHttpClient.Builder client = new OkHttpClient.Builder();

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Host.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            ;

    private static Retrofit retrofit = retrofitBuilder.build();

    public static <S> S creatService(Class<S> service){
        return retrofit.create(service);
    }
}
