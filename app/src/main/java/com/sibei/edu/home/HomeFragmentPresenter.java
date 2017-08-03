package com.sibei.edu.home;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/19
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:抽离出HomeFragment的业务逻辑
 */


public interface HomeFragmentPresenter {

    void getHomeData();

    void getCourseId(int groupPosition,int childPosition);

}
