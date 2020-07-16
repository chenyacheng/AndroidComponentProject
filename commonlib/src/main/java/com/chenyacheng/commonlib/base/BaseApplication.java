package com.chenyacheng.commonlib.base;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

/**
 * 每个组件实现自己的Application，并且继承BaseApplication.
 * 组件模块中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用.
 * 组件模块的Application需置于java/debug文件夹中，不得放于主代码.
 *
 * @author chenyacheng
 * @date 2019/01/18
 */
public class BaseApplication extends Application {

    private static BaseApplication application;

    public static BaseApplication getApplication() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // 5.0以下机型无法运行应用
        MultiDex.install(this);
    }
}
