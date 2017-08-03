package com.sibei.edu.image;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Author：MaxLong
 * WeChat：Longalei888
 * Date：2017/7/18
 * Signature:每一个Bug修改,每一次充分思考,都会是一种进步.
 * Describtion:图片加载器
 */


public class ImageLoader {


    private static class ImageLoaderHolder {
        private static final ImageLoader instance = new ImageLoader();
    }

    public static ImageLoader getInstance() {
        return ImageLoaderHolder.instance;
    }

    public void load(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }
}
