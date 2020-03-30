package com.chenyacheng.commonlib.store;

import android.content.Context;

import com.chenyacheng.commonlib.utils.SharedPreferencesUtils;

/**
 * 用户信息存储
 *
 * @author chenyacheng
 * @date 2019/01/24
 */
public class UserInfo {

    public static final String REAL_NAME = "real_name";
    public static final String USER_PHONE = "user_phone";
    public static final String USER_ID = "user_id";
    /**
     * 当前纬度
     */
    public static final String CURRENT_LATITUDE = "current_latitude";
    /**
     * 当前经度
     */
    public static final String CURRENT_LONGITUDE = "current_longitude";
    private static SharedPreferencesUtils sharedPreferencesUtils;
    private volatile static UserInfo instance = null;

    private UserInfo() {
    }

    public static UserInfo getInstance() {
        if (instance == null) {
            synchronized (UserInfo.class) {
                if (instance == null) {
                    instance = new UserInfo();
                }
            }
        }
        return instance;
    }

    public static void init(Context context) {
        sharedPreferencesUtils = new SharedPreferencesUtils(context, "userInfo");
    }

    public boolean isLogin() {
        return instance.getData(USER_ID, null) != null;
    }

    public Object getData(String key, Object defaultObject) {
        return sharedPreferencesUtils.getSharedPreference(key, defaultObject);
    }

    public void setData(String key, Object object) {
        sharedPreferencesUtils.putSharedPreference(key, object);
    }

    public void clearAllData() {
        sharedPreferencesUtils.clear();
    }
}
