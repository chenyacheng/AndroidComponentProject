package com.chenyacheng.commonlib.progress;

/**
 * 请求监听成功或者失败
 *
 * @author chenyacheng
 * @date 2019/01/17
 */
public interface ObserverResponseListener {

    /**
     * 响应成功
     *
     * @param t 返回T的对象
     */
    void onSuccess(Object t);

    /**
     * 响应失败
     *
     * @param e 返回Throwable的对象
     */
    void onFail(Throwable e);
}
