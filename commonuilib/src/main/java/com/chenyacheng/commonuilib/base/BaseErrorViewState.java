package com.chenyacheng.commonuilib.base;

import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;

/**
 * 基本的错误视图模型
 *
 * @author chenyacheng
 * @date 2019/09/04
 */
public class BaseErrorViewState {

    /**
     * 接收服务端异常数据的处理，或是自定义数据的处理，发送信息通知界面
     */
    private final ExceptionHandleUtils error;

    public BaseErrorViewState(ExceptionHandleUtils error) {
        this.error = error;
    }

    public ExceptionHandleUtils getError() {
        return error;
    }
}
