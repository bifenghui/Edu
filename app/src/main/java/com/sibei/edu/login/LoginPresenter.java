package com.sibei.edu.login;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/13
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:抽离LoginActivity的业务接口
 */


public interface LoginPresenter {

    void verifyAccount(String phone,String code);

    void getCode(String phone);

    void onDestroy();

}
