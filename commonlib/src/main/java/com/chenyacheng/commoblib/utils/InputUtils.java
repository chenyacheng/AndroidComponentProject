package com.chenyacheng.commoblib.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * 输入法工具类
 *
 * @author chenyacheng
 * @date 2019/04/19
 */
public class InputUtils {
    /**
     * 隐藏输入法
     */
    public static void hideSoftInput(Activity activity) {
        // 拿到InputMethodManager
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null == imm) {
            return;
        }
        // isActive返回true表示打开状态
        if (imm.isActive()) {
            if (activity.getCurrentFocus() != null) {
                // 有焦点关闭
                imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            } else {
                // 无焦点关闭
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            }
        }
    }
}
