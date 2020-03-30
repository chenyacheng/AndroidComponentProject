package com.chenyacheng.commonlib.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * 自定义Glide图片加载
 *
 * @author chenyacheng
 * @date 2019/01/18
 */
public class GlideUtils {

    public static void disPlayerImageView(Context context, ImageView imageView, String url, int imgDrawable) {
        RequestOptions requestOptions = new RequestOptions()
                // 加载成功之前占位图
                .placeholder(imgDrawable)
                // 加载错误之后的错误图
                .error(imgDrawable);
        Glide.with(context).load(url).apply(requestOptions).into(imageView);
    }

    public static void disPlayerImageView(Context context, ImageView imageView, String url, float thumbnail, int imgDrawable) {
        RequestOptions requestOptions = new RequestOptions()
                // 加载成功之前占位图
                .placeholder(imgDrawable)
                // 加载错误之后的错误图
                .error(imgDrawable);
        Glide.with(context).load(url).thumbnail(thumbnail).apply(requestOptions).into(imageView);
    }
}
