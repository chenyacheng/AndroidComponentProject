package com.chenyacheng.commonuilib;

import com.chenyacheng.commonlib.progress.ObserverResponseListener;
import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;
import com.chenyacheng.commonuilib.utils.GsonUtils;
import com.chenyacheng.commonuilib.utils.LogUtils;

/**
 * 处理后台返回的数据格式
 *
 * @author chenyacheng
 * @date 2020/07/16
 */
public class ResponseDataFormat implements ObserverResponseListener {

    private ResponseListener responseListener;

    public ResponseDataFormat(ResponseListener responseListener) {
        this.responseListener = responseListener;
    }

    @Override
    public void onSuccess(Object t) {
        BaseResponse baseResponse = GsonUtils.removeSpaceFromJson(t, BaseResponse.class);
        if (null != responseListener) {
            String code = "200";
            if (code.equals(baseResponse.getCode())) {
                responseListener.onSuccess(baseResponse.getData());
            } else {
                ExceptionHandleUtils exceptionHandleUtils = new ExceptionHandleUtils(true, baseResponse.getCode(), baseResponse.getMessage());
                responseListener.onFail(exceptionHandleUtils);
            }
        }
    }

    @Override
    public void onFail(Throwable e) {
        if (null != responseListener) {
            LogUtils.showLogCompletion("onFail:", e.toString(), 1000, "verbose");
            // 自定义异常处理
            ExceptionHandleUtils exceptionHandleUtils = ExceptionHandleUtils.handleException(e);
            responseListener.onFail(exceptionHandleUtils);
        }
    }
}
