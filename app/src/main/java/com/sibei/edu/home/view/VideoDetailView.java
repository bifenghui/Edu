package com.sibei.edu.home.view;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/21
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:视频详情抽离的视图接口
 */


public interface VideoDetailView {

    void setVideoUrl(String url);

    void fillData(String title,String remark,String content);
}
