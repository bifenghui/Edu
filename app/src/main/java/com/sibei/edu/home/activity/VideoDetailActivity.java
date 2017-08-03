package com.sibei.edu.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.sibei.edu.R;
import com.sibei.edu.base.ToolbarActivity;
import com.sibei.edu.home.presenter.VideoDetailPresenter;
import com.sibei.edu.home.presenter.presenterImp.VideoDetailPresenterImp;
import com.sibei.edu.home.view.VideoDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/21
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:视频详情页面
 */
public class VideoDetailActivity extends ToolbarActivity implements VideoDetailView{
    private static final String TAG = "VideoDetailActivity";

    @BindView(R.id.detail_video_view)
    JCVideoPlayerStandard detailVideoView;
    @BindView(R.id.detail_title)
    TextView detailTitle;
    @BindView(R.id.detail_remark)
    TextView detailRemark;
    @BindView(R.id.detail_content)
    TextView detailContent;

    private VideoDetailPresenter videoDetailPresenter;

    public static void start(Context context, String id) {
        Intent intent = new Intent();
        intent.putExtra("id", id);
        intent.setClass(context, VideoDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        ButterKnife.bind(this);
        setTitle("视频详情");
        setCanBack(true);
        videoDetailPresenter = new VideoDetailPresenterImp(this);
        videoDetailPresenter.requestData(getIntent().getStringExtra("id"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void setVideoUrl(String url) {
        detailVideoView.setUp(url, JCVideoPlayer.SCREEN_LAYOUT_NORMAL);
    }

    @Override
    public void fillData(String title, String remark, String content) {
        detailTitle.setText(title);
        detailRemark.setText(remark);
        detailContent.setText(content);
    }

    @Override
    public void onBackPressed() {
        if(JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
}
