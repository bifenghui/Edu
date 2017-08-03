package com.sibei.edu.home.presenter;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/20
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:课程列表业务逻辑接口
 */


public interface CourseListPresenter {

    void getCourseListData(String class_id);

    void refresh(String class_id);

    void loadMore(String class_id);
}
