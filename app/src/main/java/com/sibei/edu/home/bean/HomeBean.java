package com.sibei.edu.home.bean;

import java.util.List;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/19
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:首页数据源
 */


public class HomeBean {

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
        private List<PptListBean> ppt_list;
        private List<ClassListBean> class_list;

        public List<PptListBean> getPpt_list() {
            return ppt_list;
        }

        public void setPpt_list(List<PptListBean> ppt_list) {
            this.ppt_list = ppt_list;
        }

        public List<ClassListBean> getClass_list() {
            return class_list;
        }

        public void setClass_list(List<ClassListBean> class_list) {
            this.class_list = class_list;
        }

        public static class PptListBean {

            private String id;
            private String pic;
            private String source_pic;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getSource_pic() {
                return source_pic;
            }

            public void setSource_pic(String source_pic) {
                this.source_pic = source_pic;
            }
        }

        public static class ClassListBean {

            private String id;
            private String name;
            private List<NextListBean> next_list;

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

            public List<NextListBean> getNext_list() {
                return next_list;
            }

            public void setNext_list(List<NextListBean> next_list) {
                this.next_list = next_list;
            }

            public static class NextListBean {

                private String id;
                private String name;
                private String pid;
                private String pic;
                private String source_pic;

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

                public String getPid() {
                    return pid;
                }

                public void setPid(String pid) {
                    this.pid = pid;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getSource_pic() {
                    return source_pic;
                }

                public void setSource_pic(String source_pic) {
                    this.source_pic = source_pic;
                }
            }
        }
    }
}
