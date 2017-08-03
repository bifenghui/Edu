package com.sibei.edu.home;

import android.content.Context;

import com.sibei.edu.home.bean.HomeBean;

import java.util.List;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/19
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:抽离主页HomeFragment的视图逻辑
 */


public interface HomeFragmentView {

    void fetchDataToBanner(List<HomeBean.InfoBean.PptListBean> ppt_list);

    void fetchDataToExpandView(List<HomeBean.InfoBean.ClassListBean> class_list);

    void goToCourseListActivity(int groupPosition,int childPosition);
}
