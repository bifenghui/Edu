package com.sibei.edu.home.bean;

import java.util.List;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/20
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:课程列表数据源
 */


public class CourseBean {

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
        private List<CourseListBean> course_list;

        public List<CourseListBean> getCourse_list() {
            return course_list;
        }

        public void setCourse_list(List<CourseListBean> course_list) {
            this.course_list = course_list;
        }

        public static class CourseListBean {

            private String id;
            private String name;
            private String video_pic;
            private String source_video_pic;
            private String lecturer_name;
            private String show_auth_vip;
            private String lecturer_info;
            private String view_num;

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

            public String getVideo_pic() {
                return video_pic;
            }

            public void setVideo_pic(String video_pic) {
                this.video_pic = video_pic;
            }

            public String getSource_video_pic() {
                return source_video_pic;
            }

            public void setSource_video_pic(String source_video_pic) {
                this.source_video_pic = source_video_pic;
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

            public String getView_num() {
                return view_num;
            }

            public void setView_num(String view_num) {
                this.view_num = view_num;
            }
        }
    }
}
