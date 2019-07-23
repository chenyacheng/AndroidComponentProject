package com.chenyacheng.wxannotaion;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 微信支付
 * 编译时注解，项目的applicationId（包名）
 *
 * @author chenyacheng
 * @date 2019/07/23
 */
@Retention(RetentionPolicy.CLASS)
public @interface WXAppId {
    String value();
}
