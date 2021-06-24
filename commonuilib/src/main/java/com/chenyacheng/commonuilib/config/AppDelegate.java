package com.chenyacheng.commonuilib.config;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.chenyacheng.commonlib.base.BaseApplication;
import com.chenyacheng.commonuilib.BuildConfig;
import com.chenyacheng.commonuilib.utils.AppDebugUtils;
import com.chenyacheng.commonuilib.utils.LogUtils;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * App的delegate
 *
 * @author chenyacheng
 * @date 2019/01/18
 */
public class AppDelegate extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        // LogUtils日志设置，false不打印日志，true打印日志
        LogUtils.setLogEnable(AppDebugUtils.isAppDebug());
        // 第三个参数为SDK调试模式开关，调试模式的行为特性如下：
        // 输出详细的Bugly SDK的Log；每一条Crash都会被立即上报；自定义日志将会在Logcat中输出。
        // 建议在测试阶段建议设置成true，发布时设置为false
        Bugly.init(BaseApplication.getApplication(), BuildConfig.BUGLY_APP_ID, BuildConfig.BUGLY_IS_DEBUG);
        CrashReport.initCrashReport(BaseApplication.getApplication(), BuildConfig.BUGLY_APP_ID, BuildConfig.BUGLY_IS_DEBUG);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // 5.0以下机型无法运行应用
        MultiDex.install(this);
    }
}
