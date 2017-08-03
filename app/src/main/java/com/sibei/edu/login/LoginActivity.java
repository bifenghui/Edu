package com.sibei.edu.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.sibei.edu.R;
import com.sibei.edu.base.BaseActivity;
import com.sibei.edu.main.MainActivity;
import com.sibei.edu.user.UserManager;
import com.sibei.edu.customview.TimerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/13
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:登录页
*/
public class LoginActivity extends BaseActivity implements LoginView{
    private static final String TAG = "LoginActivity";
    @BindView(R.id.login_acount)
    EditText login_acount;
    @BindView(R.id.login_code)
    EditText login_code;
    @BindView(R.id.login_progressbar)
    ProgressBar login_progressbar;
    @BindView(R.id.login_code_get)
    TimerView login_code_get;

    private LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImpl(this);
        checkLogin();
    }

    private void checkLogin() {
        if(UserManager.isLogin()){
            goToMain();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }

    @OnClick({R.id.login_button,R.id.login_code_get})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_button:
                loginPresenter.verifyAccount(login_acount.getText().toString(),login_code.getText().toString());
                break;
            case R.id.login_code_get:
                loginPresenter.getCode(login_acount.getText().toString());
                break;
        }
    }

    @Override
    public void showProgress() {
        login_progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        login_progressbar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void startTimer() {
        login_code_get.startTimer();
    }

    @Override
    public void goToMain() {
        MainActivity.start(this);
        finish();
    }
}
