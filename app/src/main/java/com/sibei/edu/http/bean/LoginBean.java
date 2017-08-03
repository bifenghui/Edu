package com.sibei.edu.http.bean;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/14
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:Post请求存放数据的Bean
 */


public class LoginBean {

    private String phone;
    private String code;

    public LoginBean(String phone, String code) {
        this.phone = phone;
        this.code = code;
    }
}
