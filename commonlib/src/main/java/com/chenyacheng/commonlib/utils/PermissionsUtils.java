package com.chenyacheng.commonlib.utils;

import android.os.Build;

/**
 * 权限类
 *
 * @author chenyacheng
 * @date 2019/04/19
 */
public class PermissionsUtils {
    /**
     * 是否应该检查权限，6.0以下为false，6.0以及以上为true
     *
     * @return true or false
     */
    public static boolean showCheckPermissions() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
}
