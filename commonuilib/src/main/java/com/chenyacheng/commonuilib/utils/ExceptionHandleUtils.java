package com.chenyacheng.commonuilib.utils;

import com.tencent.bugly.crashreport.CrashReport;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

/**
 * 失败处理类：1.异常2.错误
 * 1.异常：服务端异常，解析数据出错，网络异常等等
 * 2.错误：请求服务端成功但返回的状态码不是约定的（00000）
 *
 * @author chenyacheng
 * @date 2019/01/17
 */
public class ExceptionHandleUtils {

    /**
     * 网络请求成功，但服务端返回的状态码不是00000，值为true；状态码是00000，值为false
     * 默认为false
     */
    public boolean isErrorStatus = false;
    public String code;
    public String message;

    public ExceptionHandleUtils(String message) {
        this.message = message;
    }

    public ExceptionHandleUtils(boolean isErrorStatus, String code, String message) {
        this.isErrorStatus = isErrorStatus;
        this.code = code;
        this.message = message;
    }

    public static ExceptionHandleUtils handleException(Throwable e) {
        ExceptionHandleUtils exceptionHandleUtils;
        if (e instanceof UnknownHostException) {
            exceptionHandleUtils = new ExceptionHandleUtils("请打开网络");
            CrashReport.postCatchedException(e);
            return exceptionHandleUtils;
        } else if (e instanceof ConnectException) {
            exceptionHandleUtils = new ExceptionHandleUtils("连接失败");
            CrashReport.postCatchedException(e);
            return exceptionHandleUtils;
        } else if (e instanceof SocketTimeoutException) {
            exceptionHandleUtils = new ExceptionHandleUtils("请求超时");
            CrashReport.postCatchedException(e);
            return exceptionHandleUtils;
        } else if (e instanceof HttpException) {
            exceptionHandleUtils = new ExceptionHandleUtils("服务器开小差了,稍后再试吧");
            CrashReport.postCatchedException(e);
            return exceptionHandleUtils;
        } else {
            exceptionHandleUtils = new ExceptionHandleUtils("服务器开小差了,稍后再试吧");
            CrashReport.postCatchedException(e);
            return exceptionHandleUtils;
        }
    }
}
