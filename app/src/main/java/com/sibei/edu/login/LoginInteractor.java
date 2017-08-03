package com.sibei.edu.login;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/13
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:登录界面关联接口
 */


public interface LoginInteractor {

     interface LoginFinishedListener{
         void onSuccess();

         void onFailure(String message);
    }

    void login(String phone,String code,LoginFinishedListener listener);

}
