package com.chenyacheng.findcomponent.proxy;

import android.content.Intent;

/**
 * 动态代理需要的登录接口
 *
 * @author chenyacheng
 * @date 2020/08/27
 */
public interface LoginIn {

    /**
     * 跳转页面
     *
     * @param intent intent
     */
    void startActivity(Intent intent);
}
