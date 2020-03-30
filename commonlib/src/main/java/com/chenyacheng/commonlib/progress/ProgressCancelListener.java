package com.chenyacheng.commonlib.progress;

/**
 * 请求监听取消时
 *
 * @author chenyacheng
 * @date 2019/01/17
 */
public interface ProgressCancelListener {
    /**
     * 取消进度
     */
    void onCancelProgress();
}
