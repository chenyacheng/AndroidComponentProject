package com.chenyacheng.commonuilib.store;

import android.content.Context;

import com.chenyacheng.commonuilib.utils.SharedPreferencesUtils;

/**
 * 其他的配置信息
 *
 * @author chenyacheng
 * @date 2019/03/29
 */
public class ConfigInfo {

    public static final String CURRENT_CITY_CODE = "current_city_code";
    /**
     * http会话session_id
     */
    public static final String HTTP_JSESSIONID = "jsessionid";
    public static final String APP_FIRST = "app_first";
    public static final String APP_VERSION_NAME = "app_version_name";
    private static SharedPreferencesUtils sharedPreferencesUtils;
    private volatile static ConfigInfo instance = null;

    private ConfigInfo() {
    }

    public static ConfigInfo getInstance() {
        if (instance == null) {
            synchronized (ConfigInfo.class) {
                if (instance == null) {
                    instance = new ConfigInfo();
                }
            }
        }
        return instance;
    }

    public static void init(Context context) {
        sharedPreferencesUtils = new SharedPreferencesUtils(context, "configInfo");
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
