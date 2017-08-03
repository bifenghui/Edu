package com.sibei.edu.home;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.sibei.edu.R;
import com.sibei.edu.home.activity.CourseListActivity;
import com.sibei.edu.home.adapter.ExpandAdapter;
import com.sibei.edu.home.bean.HomeBean;
import com.sibei.edu.home.extra.BannerImgLoader;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/14
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:首页
*/
public class HomeFragment extends Fragment implements HomeFragmentView{
    private static final String TAG = "HomeFragment";

    @BindView(R.id.home_expand_listview)
    ExpandableListView home_expand_listview;

    private View view;
    private Banner home_banner;
    private HomeFragmentPresenter homeFragmentPresenter;
    private ExpandAdapter expandAdapter;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
        if(view==null){
            view = inflater.inflate(R.layout.fragment_home, container, false);
            ButterKnife.bind(this, view);
            init();
            homeFragmentPresenter = new HomeFragmentPresenterImp(this);
            homeFragmentPresenter.getHomeData();
        }
        return view;
    }

    private void init() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_header, null);
        home_banner = (Banner) view.findViewById(R.id.home_banner);
        home_expand_listview.addHeaderView(view);
        home_expand_listview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                homeFragmentPresenter.getCourseId(groupPosition,childPosition);
                return false;
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        home_banner.stopAutoPlay();
    }


    @Override
    public void fetchDataToBanner(List<HomeBean.InfoBean.PptListBean> ppt_list) {
        home_banner.setImageLoader(new BannerImgLoader());
        home_banner.setImages(ppt_list);
        home_banner.start();
    }

    @Override
    public void fetchDataToExpandView(List<HomeBean.InfoBean.ClassListBean> class_list) {
        expandAdapter = new ExpandAdapter(class_list);
        home_expand_listview.setAdapter(expandAdapter);
    }

    @Override
    public void goToCourseListActivity(int groupPosition,int childPosition) {
        CourseListActivity.start(getActivity(),expandAdapter.getChild(groupPosition,childPosition).getId());
    }

}
