package com.wfw.wodujiagongyu.wx.annotaion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 微信支付
 * 编译时注解，项目的applicationId（包名）
 */
@Retention(RetentionPolicy.CLASS)
public @interface WXAppId {
    String value();
}
