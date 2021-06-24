package com.chenyacheng.commonlib.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import com.chenyacheng.commonlib.base.BaseApplication;

/**
 * 网络连接工具类
 *
 * @author chenyacheng
 * @date 2019/01/18
 */
public class NetWorkUtils {

    /**
     * 网络是否连接判断工具
     */
    public static boolean isNetConnected() {
        ConnectivityManager connectivity = (ConnectivityManager) BaseApplication.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //获取网络属性
            assert connectivity != null;
            NetworkCapabilities networkCapabilities = connectivity.getNetworkCapabilities(connectivity.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
            }
        } else {
            if (connectivity != null) {
                NetworkInfo info = connectivity.getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    return info.getDetailedState() == NetworkInfo.DetailedState.CONNECTED;
                }
            }
        }
        return false;
    }
}