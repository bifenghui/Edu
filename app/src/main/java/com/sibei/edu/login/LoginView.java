package com.sibei.edu.login;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/13
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:抽离LoginActivity视图接口
 */


public interface LoginView {

    void showProgress();

    void hideProgress();

    void startTimer();

    void goToMain();
}
