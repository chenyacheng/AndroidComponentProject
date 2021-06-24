package com.chenyacheng.commonuilib.utils;

import android.content.Context;

/**
 * 密度转换工具类
 *
 * @author chenyacheng
 * @date 2019/04/10
 */
public class DensityConvertUtils {

    private static volatile DensityConvertUtils instance = null;
    private final Context mContext;

    private DensityConvertUtils(Context context) {
        // 这里变化了，把当前Context指向个应用程序的Context
        this.mContext = context.getApplicationContext();
    }

    public static DensityConvertUtils getInstance(Context context) {
        if (instance != null) {
            synchronized (DensityConvertUtils.class) {
                if (instance != null) {
                    instance = new DensityConvertUtils(context);
                }
            }
        }

        return instance;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param dps dp值
     * @return px值
     */
    public int dpToPx(float dps) {
        return Math.round(mContext.getResources().getDisplayMetrics().density * dps);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param pxs px值
     * @return dp值
     */
    public int pxToDp(float pxs) {
        return Math.round(pxs / mContext.getResources().getDisplayMetrics().density);
    }
}
