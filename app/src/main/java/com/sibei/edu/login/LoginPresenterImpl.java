package com.sibei.edu.login;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.sibei.edu.app.App;
import com.sibei.edu.http.ServiceGenerator;
import com.sibei.edu.http.bean.LoginBean;
import com.sibei.edu.http.client.LoginClient;
import com.sibei.edu.http.constants.JKey;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/13
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:业务实现逻辑类
 */


public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.LoginFinishedListener{

    private LoginView loginView;
    private LoginInteractor loginInteractor;


    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void verifyAccount(String phone, String code) {
        if(loginView!=null){
            loginView.showProgress();
        }
        loginInteractor.login(phone,code,this);
    }

    @Override
    public void getCode(String phone) {
        //具体实现获取验证码
        if(TextUtils.isEmpty(phone)){
            Toast.makeText(App.getContext(), "请先输入你的手机号", Toast.LENGTH_SHORT).show();
        }else {
            if(loginView!=null){
                loginView.startTimer();
            }
            LoginClient loginClient = ServiceGenerator.creatService(LoginClient.class);
            Call<JsonObject> code = loginClient.getCode(phone);
            code.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if(response.isSuccessful()){

                    }
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {

                }
            });
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onSuccess() {
        if(loginView!=null){
            loginView.hideProgress();
            loginView.goToMain();
        }
    }

    @Override
    public void onFailure(String message) {
        if(loginView!=null){
            loginView.hideProgress();
        }
        Toast.makeText(App.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
