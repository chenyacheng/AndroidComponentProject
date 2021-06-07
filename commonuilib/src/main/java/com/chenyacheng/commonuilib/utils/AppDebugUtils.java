package com.chenyacheng.commonuilib.utils;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.chenyacheng.commonlib.base.BaseApplication;

/**
 * 判断App是不是debug模式
 *
 * @author chenyacheng
 * @date 2019/01/18
 */
public class AppDebugUtils {

    /**
     * 判断App是否是Debug版本
     *
     * @return true是debug，false不是debug
     */
    public static boolean isAppDebug() {
        String packageName = BaseApplication.getApplication().getPackageName();
        if (packageName == null || packageName.trim().length() == 0) {
            return false;
        }
        try {
            PackageManager pm = BaseApplication.getApplication().getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(BaseApplication.getApplication().getPackageName(), 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
