package com.sibei.edu.user;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/2/22
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:用户信息管理类
 */


public class UserManager {

    //验证是否登录
    public static boolean isLogin() {
        if (Preferences.getId() != null) {
            return true;
        }
        return false;
    }

    //清除个人缓存信息
    public static void clearCache(){
        Preferences.getSharedPreferences().edit().clear().apply();
        UserPreferences.getSharedPreferences().edit().clear().apply();
    }
}
