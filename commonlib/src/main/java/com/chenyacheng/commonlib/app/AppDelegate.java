package com.chenyacheng.commonlib.app;

import android.app.Application;

import com.chenyacheng.commonlib.BuildConfig;
import com.chenyacheng.commonlib.store.ConfigInfo;
import com.chenyacheng.commonlib.store.UserInfo;
import com.chenyacheng.commonlib.utils.AppDebugUtils;
import com.chenyacheng.commonlib.utils.LogUtils;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * App的delegate
 *
 * @author chenyacheng
 * @date 2019/01/18
 */
public class AppDelegate {

    private Application application;

    public AppDelegate(Application application) {
        this.application = application;
    }

    public void onCreate() {
        // LogUtils日志设置，false不打印日志，true打印日志
        LogUtils.setLogEnable(AppDebugUtils.isAppDebug());
        // 第三个参数为SDK调试模式开关，调试模式的行为特性如下：
        // 输出详细的Bugly SDK的Log；每一条Crash都会被立即上报；自定义日志将会在Logcat中输出。
        // 建议在测试阶段建议设置成true，发布时设置为false
        Bugly.init(application, BuildConfig.BUGLY_APP_ID, BuildConfig.BUGLY_IS_DEBUG);
        CrashReport.initCrashReport(application, BuildConfig.BUGLY_APP_ID, BuildConfig.BUGLY_IS_DEBUG);
        // 初始化用户信息
        UserInfo.init(application);
        // 初始化配置信息
        ConfigInfo.init(application);
        if (LeakCanary.isInAnalyzerProcess(application)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(application);
    }
}
