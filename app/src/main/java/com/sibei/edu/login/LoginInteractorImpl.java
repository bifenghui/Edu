package com.sibei.edu.login;

import android.text.TextUtils;
import android.util.Log;

import com.sibei.edu.http.ServiceGenerator;
import com.sibei.edu.http.client.LoginClient;
import com.sibei.edu.http.constants.JValue;
import com.sibei.edu.login.bean.User;
import com.sibei.edu.user.Preferences;
import com.sibei.edu.user.UserPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/13
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:登录逻辑控制层实现
 */


public class LoginInteractorImpl implements LoginInteractor {
    private static final String TAG = "LoginInteractorImpl";

    @Override
    public void login(String phone, String code, final LoginFinishedListener listener) {
        if(TextUtils.isEmpty(phone)||TextUtils.isEmpty(code)){
            listener.onFailure("帐号或验证码不能为空");
        }else{
            LoginClient loginClient = ServiceGenerator.creatService(LoginClient.class);
            Call<User> userCall = loginClient.login(phone,code);
            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful()){
                        User user = response.body();
                        if(user.getResult().equals(JValue.SUCCESS)){
                            User.InfoBean.UserInfoBean user_info = user.getInfo().getUser_info();
                            Preferences.saveId(user_info.getId());
                            Preferences.saveToken(user_info.getLogin_token());
                            UserPreferences.Buidler builder = new UserPreferences.Buidler()
                                    .setNickname(user_info.getNickname())
                                    .setPhoto(user_info.getSource_photo());
                            builder.build();
                            listener.onSuccess();
                        }else {
                            listener.onFailure("你的帐号或验证码有误,请重新输入");
                        }
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    listener.onFailure("网络异常,请检查你的网络连接");
                }
            });
        }
    }
}
