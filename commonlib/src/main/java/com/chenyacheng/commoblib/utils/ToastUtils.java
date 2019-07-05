package com.chenyacheng.commoblib.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.res.ResourcesCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chenyacheng.commoblib.R;
import com.chenyacheng.commoblib.base.BaseApplication;

/**
 * 自定义Toast工具类
 *
 * @author chenyacheng
 * @date 2019/01/18
 */
public class ToastUtils {

    private static Toast toast;

    public static void showCustomToastLayout(int layout, int resId, String msg, int duration) {
        showCustomLayout(BaseApplication.getApplication(), layout, resId, msg, duration);
    }

    private static void showCustomLayout(final Context context, int layout, int resId, final String msg, final int duration) {
        if (context == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (toast == null) {
                toast = new Toast(context.getApplicationContext());
            }
            createToastView(context, layout, resId, msg, duration, R.id.message);
        } else {
            new Handler(Looper.getMainLooper()).post(() -> {
                if (toast == null) {
                    toast = new Toast(context.getApplicationContext());
                }
                createToastView(context, layout, resId, msg, duration, R.id.message);
            });
        }
    }

    private static void createToastView(Context context, int layout, int resId, String msg, int duration, int p) {
        View toastLayout = View.inflate(context.getApplicationContext(), layout, null);
        TextView toastMessage = toastLayout.findViewById(p);
        Drawable drawableIcon = ResourcesCompat.getDrawable(context.getResources(), resId, null);
        if (null != drawableIcon) {
            drawableIcon.setBounds(0, 0, drawableIcon.getMinimumWidth(), drawableIcon.getMinimumHeight());
            toastMessage.setCompoundDrawables(null, drawableIcon, null, null);
        }
        toastMessage.setText(msg);
        toast.setDuration(duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(toastLayout);
        toast.show();
    }

    public static void showShortToast(String msg) {
        showCustomToast(BaseApplication.getApplication(), msg, Toast.LENGTH_SHORT);
    }

    private static void showCustomToast(final Context context, final String msg, final int duration) {
        if (context == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            showToast(context, msg, duration);
        } else {
            new Handler(Looper.getMainLooper()).post(() -> showToast(context, msg, duration));
        }
    }

    private static void showToast(Context context, String msg, int duration) {
        if (null != context) {
            if (toast == null) {
                toast = new Toast(context.getApplicationContext());
            }
            View layout = View.inflate(context.getApplicationContext(), R.layout.toast_layout, null);
            TextView toastMessage = layout.findViewById(R.id.message);
            toastMessage.setText(msg);
            toast.setDuration(duration);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.setView(layout);
            toast.show();
        }
    }

    public static void toastCancel() {
        if (null != toast) {
            toast.cancel();
        }
    }

    public static void showShortToast(int msgId) {
        showCustomToast(BaseApplication.getApplication(), msgId, Toast.LENGTH_SHORT);
    }

    private static void showCustomToast(Context context, int msgId, int duration) {
        final String msg = context.getResources().getString(msgId);
        showCustomToast(context, msg, duration);
    }

    public static void showLongToast(String msg) {
        showCustomToast(BaseApplication.getApplication(), msg, Toast.LENGTH_LONG);
    }

    public static void showLongToast(int msgId) {
        showCustomToast(BaseApplication.getApplication(), msgId, Toast.LENGTH_LONG);
    }

    public static void showToastInUiThread(final Activity activity, final String msg) {
        if (activity != null) {
            activity.runOnUiThread(() -> showCustomToast(activity, msg));
        }
    }

    private static void showCustomToast(Context context, String msg) {
        showCustomToast(context, msg, Toast.LENGTH_SHORT);
    }

    public static void showToastInUiThread(final Activity activity, final int stringId) {
        if (activity != null) {
            activity.runOnUiThread(() -> showCustomToast(activity, stringId));
        }
    }

    private static void showCustomToast(Context context, int msgId) {
        final String msg = context.getResources().getString(msgId);
        showCustomToast(context, msg);
    }
}
