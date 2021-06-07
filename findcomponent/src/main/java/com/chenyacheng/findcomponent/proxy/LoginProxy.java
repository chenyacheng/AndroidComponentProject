package com.chenyacheng.findcomponent.proxy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理的实现登录功能
 *
 * @author chenyacheng
 * @date 2020/08/27
 */
public class LoginProxy implements InvocationHandler {

    private final LoginIn launchManagerService;
    private final Context context;

    public LoginProxy(Context context, LoginIn launchManagerService) {
        this.context = context;
        this.launchManagerService = launchManagerService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!Config.isLogin) {
            Intent intent = (Intent) args[0];
            ComponentName component = intent.getComponent();
            String className = component.getClassName();
            Bundle bundleExtra = intent.getBundleExtra(Config.KEY_DATA);
            bundleExtra.putString(Config.KEY_CLASS_NAME, className);
            intent.putExtra(Config.KEY_DATA, bundleExtra);
            intent.setClass(context, Login1Activity.class);
        }
        method.invoke(launchManagerService, args);
        return null;
    }
}
