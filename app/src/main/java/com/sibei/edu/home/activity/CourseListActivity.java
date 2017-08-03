package com.sibei.edu.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ProgressBar;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.sibei.edu.R;
import com.sibei.edu.base.ToolbarActivity;
import com.sibei.edu.home.adapter.CourseListAdapter;
import com.sibei.edu.home.bean.CourseBean;
import com.sibei.edu.home.interfaces.OnItemClickListener;
import com.sibei.edu.home.presenter.CourseListPresenter;
import com.sibei.edu.home.presenter.presenterImp.CourseListPresenterImp;
import com.sibei.edu.home.view.CourseListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/19
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:课程列表界面
*/
public class CourseListActivity extends ToolbarActivity implements CourseListView<CourseBean>,XRecyclerView.LoadingListener,OnItemClickListener{

    @BindView(R.id.course_list_xrecyclerview)
    XRecyclerView course_list_xrecyclerview;
    @BindView(R.id.course_list_progressbar)
    ProgressBar course_list_progressbar;

    private CourseListAdapter courseListAdapter;
    private CourseListPresenter courseListPresenter;


    public static void start(Context context,String class_id) {
        Intent intent = new Intent();
        intent.putExtra("class_id", class_id);
        intent.setClass(context, CourseListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        ButterKnife.bind(this);
        setCanBack(true);
        setTitle("课程列表");
        course_list_xrecyclerview.setLoadingListener(this);
        course_list_xrecyclerview.setArrowImageView(R.drawable.ic_arrow_downward_black_24dp);
        courseListPresenter = new CourseListPresenterImp(this);
        courseListPresenter.getCourseListData(getIntent().getStringExtra("class_id"));
    }


    @Override
    public void showProgress() {
        course_list_progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        course_list_progressbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showListData(CourseBean data) {
        courseListAdapter = new CourseListAdapter(data.getInfo().getCourse_list());
        courseListAdapter.setOnItemClickListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        course_list_xrecyclerview.setLayoutManager(manager);
        course_list_xrecyclerview.setAdapter(courseListAdapter);
    }

    @Override
    public void refreshComplete() {
        course_list_xrecyclerview.refreshComplete();
        course_list_xrecyclerview.loadMoreComplete();
    }

    @Override
    public void refreshData(CourseBean data) {
        courseListAdapter.refreshData(data.getInfo().getCourse_list());
    }

    @Override
    public void loadData(CourseBean data) {
        courseListAdapter.loadData(data.getInfo().getCourse_list());
    }

    @Override
    public void onRefresh() {
        courseListPresenter.refresh(getIntent().getStringExtra("class_id"));
    }

    @Override
    public void onLoadMore() {
        courseListPresenter.loadMore(getIntent().getStringExtra("class_id"));
    }

    @Override
    public void OnItemClick(String id) {
        VideoDetailActivity.start(this,id);
    }
}
