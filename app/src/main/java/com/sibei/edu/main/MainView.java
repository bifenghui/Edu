package com.sibei.edu.main;

import android.app.Fragment;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/14
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:抽离出的MainActivity的View接口
 */


public interface MainView {

    void setBottomBarHomeSelected();

    void setBottomBarMineSelected();

    void showHomeFragment();

    void showMineFragment();
}
