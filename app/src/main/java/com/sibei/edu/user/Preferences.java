package com.sibei.edu.user;

import android.content.Context;
import android.content.SharedPreferences;

import com.sibei.edu.app.App;


/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/2/22
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:管理用户帐号和密码的类
 */


public class Preferences {
    public static final String FILENAME = "edu_user";
    private static final String ID = "id";
    private static final String TOKEN = "token";

    public static void saveId(String account) {
        saveString(ID, account);
    }

    public static String getId() {
        return getString(ID);
    }

    public static void saveToken(String token) {
        saveString(TOKEN, token);
    }

    public static String getToken() {
        return getString(TOKEN);
    }

    private static void saveString(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(key, value);
        editor.apply();
    }

    private static String getString(String key) {
        return getSharedPreferences().getString(key, null);
    }

    static SharedPreferences getSharedPreferences() {
        return App.getContext().getSharedPreferences(Preferences.FILENAME, Context.MODE_PRIVATE);
    }
}
