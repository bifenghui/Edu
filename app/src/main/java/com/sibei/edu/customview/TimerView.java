package com.sibei.edu.customview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sibei.edu.R;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/17
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:倒计时控件TextView
 */


public class TimerView extends FrameLayout {
    private static final String TAG = "TimerView";
    private TextView timerview;
    private boolean isBegin;

    public TimerView(Context context) {
        this(context,null);
    }

    public TimerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_timer_view, null);
        timerview = (TextView) view.findViewById(R.id.timerview);
        addView(view);
    }

    public void startTimer(){
        if(!isBegin){
            isBegin = true;
            timerview.setBackground(getResources().getDrawable(R.drawable.shape_bo_grey_cccccc_r4dp));
            timerview.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(getContext(),R.color.grey_cccccc)));
            new CountDownTimer(60000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timerview.setText(millisUntilFinished/1000 + "s");
                }

                @Override
                public void onFinish() {
                    timerview.setBackground(getResources().getDrawable(R.drawable.shape_bo_white_r4dp));
                    timerview.setTextColor(ColorStateList.valueOf(ContextCompat.getColor(getContext(),R.color.white)));
                    timerview.setText("获取验证码");
                    isBegin = false;
                }
            }.start();
        }
    }
}
