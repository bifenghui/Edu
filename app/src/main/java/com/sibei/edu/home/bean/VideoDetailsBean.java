package com.sibei.edu.home.bean;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/21
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:视频详情数据源
 */


public class VideoDetailsBean {

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

        private CourseInfoBean course_info;

        public CourseInfoBean getCourse_info() {
            return course_info;
        }

        public void setCourse_info(CourseInfoBean course_info) {
            this.course_info = course_info;
        }

        public static class CourseInfoBean {

            private String id;
            private String name;
            private String video_url;
            private String lecturer_name;
            private String show_auth_vip;
            private String lecturer_info;
            private String lecturer_from;
            private String content;
            private String class_name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getVideo_url() {
                return video_url;
            }

            public void setVideo_url(String video_url) {
                this.video_url = video_url;
            }

            public String getLecturer_name() {
                return lecturer_name;
            }

            public void setLecturer_name(String lecturer_name) {
                this.lecturer_name = lecturer_name;
            }

            public String getShow_auth_vip() {
                return show_auth_vip;
            }

            public void setShow_auth_vip(String show_auth_vip) {
                this.show_auth_vip = show_auth_vip;
            }

            public String getLecturer_info() {
                return lecturer_info;
            }

            public void setLecturer_info(String lecturer_info) {
                this.lecturer_info = lecturer_info;
            }

            public String getLecturer_from() {
                return lecturer_from;
            }

            public void setLecturer_from(String lecturer_from) {
                this.lecturer_from = lecturer_from;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getClass_name() {
                return class_name;
            }

            public void setClass_name(String class_name) {
                this.class_name = class_name;
            }
        }
    }
}
