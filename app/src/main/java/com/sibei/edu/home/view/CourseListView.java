package com.sibei.edu.home.view;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/20
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:
 */


public interface CourseListView<T> {

    void showProgress();

    void hideProgress();

    void showListData(T data);

    void refreshComplete();

    void refreshData(T data);

    void loadData(T data);
}
