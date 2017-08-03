package com.sibei.edu.home.extra;

import android.content.Context;
import android.widget.ImageView;

import com.sibei.edu.home.bean.HomeBean;
import com.youth.banner.loader.ImageLoader;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/18
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:
 */


public class BannerImgLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        com.sibei.edu.image.ImageLoader.getInstance().load(context,
                ((HomeBean.InfoBean.PptListBean)path).getPic(),imageView);
    }
}
