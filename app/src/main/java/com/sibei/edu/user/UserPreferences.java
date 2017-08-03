package com.sibei.edu.user;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.sibei.edu.app.App;


/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/2/22
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:个人用户信息类
 */


public class UserPreferences {
    public static final String NICKNAME = "nickname";
    public static final String PHOTO = "photo";
    public static final String SEX = "sex";
    public static final String SIGNATURE = "signature";

    public UserPreferences(Buidler buidler) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        if (buidler.nickname != null) {
            edit.putString(NICKNAME, buidler.nickname);
        }
        if (buidler.photo != null) {
            edit.putString(PHOTO, buidler.photo);
        }
        if (buidler.sex != null) {
            edit.putString(SEX, buidler.sex);
        }
        if (buidler.signature != null) {
            edit.putString(SIGNATURE, buidler.signature);
        }
        edit.apply();
    }

    public static String getNICKNAME() {
        return getSharedPreferences().getString(NICKNAME, null);
    }

    public static String getPHOTO() {
        return getSharedPreferences().getString(PHOTO, null);
    }

    public static String getSEX() {
        return getSharedPreferences().getString(SEX, null);
    }

    public static String getSIGNATURE() {
        if (TextUtils.isEmpty(getSharedPreferences().getString(SIGNATURE, null))) {
            return "这个人什么也没留下哦";
        }
        return getSharedPreferences().getString(SIGNATURE, null);
    }

    public static class Buidler {
        private String nickname;
        private String photo;
        private String sex;
        private String signature;

        public Buidler setNickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Buidler setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Buidler setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Buidler setSignature(String signature) {
            this.signature = signature;
            return this;
        }

        public UserPreferences build() {
            UserPreferences manager = new UserPreferences(this);
            return manager;
        }
    }

    public static SharedPreferences getSharedPreferences() {
        return App.getContext().getSharedPreferences(Preferences.FILENAME + Preferences.getId(), Context.MODE_PRIVATE);
    }
}
