package com.chenyacheng.commonuilib.base;

import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;

/**
 * 请求监听成功或者失败
 *
 * @author chenyacheng
 * @date 2020/07/16
 */
public interface ResponseListener {

    /**
     * 响应成功
     *
     * @param t 返回T的对象
     */
    void onSuccess(Object t);

    /**
     * 响应失败
     *
     * @param e 返回ExceptionHandleUtils的对象
     */
    void onFail(ExceptionHandleUtils e);
}
