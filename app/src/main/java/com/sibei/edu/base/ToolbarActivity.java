package com.sibei.edu.base;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sibei.edu.R;
/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/14
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:标题栏基类
*/
public class ToolbarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView toolbar_title;
    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (layoutResID == R.layout.activity_toolbar) {
            //提供基本视图
            super.setContentView(layoutResID);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar_title = (TextView) findViewById(R.id.toolbar_title);
            container = (FrameLayout) findViewById(R.id.container);
            container.removeAllViews();
        } else {
            LayoutInflater.from(this).inflate(layoutResID, container, true);
        }
    }

    public void setTitle(String title){
        toolbar_title.setText(title);
    }

    public void setCanBack(boolean isCanBack){
        if(isCanBack){
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}
