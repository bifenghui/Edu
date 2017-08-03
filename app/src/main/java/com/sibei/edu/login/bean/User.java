package com.sibei.edu.login.bean;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/14
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:定义登录成功后获取的用户数据源
 */


public class User {

    private String result;
    private InfoBean info;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {

        private UserInfoBean user_info;

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public static class UserInfoBean {

            private String id;
            private String nickname;
            private String photo;
            private String source_photo;
            private String login_token;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getSource_photo() {
                return source_photo;
            }

            public void setSource_photo(String source_photo) {
                this.source_photo = source_photo;
            }

            public String getLogin_token() {
                return login_token;
            }

            public void setLogin_token(String login_token) {
                this.login_token = login_token;
            }
        }
    }
}
