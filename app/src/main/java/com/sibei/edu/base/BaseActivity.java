package com.sibei.edu.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jaeger.library.StatusBarUtil;
import com.sibei.edu.R;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/13
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:BaseActivity
*/
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setStatusBar();
    }

    public void setStatusBar(){
        StatusBarUtil.setColor(this, getResources().getColor(R.color.black));
    }
}
