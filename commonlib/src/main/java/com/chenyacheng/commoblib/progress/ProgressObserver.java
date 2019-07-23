package com.chenyacheng.commoblib.progress;

import android.content.Context;

import com.chenyacheng.commoblib.base.BaseResponse;
import com.chenyacheng.commoblib.constant.StatusCode;
import com.chenyacheng.commoblib.utils.ExceptionHandleUtils;
import com.chenyacheng.commoblib.utils.LogUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 观察者，继承与Observer，监听请求是否成功
 *
 * @author chenyacheng
 * @date 2019/01/17
 */
public class ProgressObserver<T> implements Observer<T>, ProgressCancelListener {

    private static final String TAG = "ProgressObserver____ ";
    private ObserverResponseListener listener;
    private ProgressDialogHandler mProgressDialogHandler;
    private Disposable d;

    public ProgressObserver(Context context, ObserverResponseListener listener, boolean isDialog, boolean cancelable) {
        this.listener = listener;
        if (isDialog) {
            mProgressDialogHandler = new ProgressDialogHandler(context, this, cancelable);
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
        showProgressDialog();
    }

    @Override
    public void onNext(T t) {
        if (listener != null) {
            BaseResponse baseResponse = (BaseResponse) t;
            if (StatusCode.REQUEST_SUCCESS.equals(baseResponse.getCode())) {
                listener.onNext(baseResponse.getData());
            } else {
                ExceptionHandleUtils exceptionHandleUtils = new ExceptionHandleUtils(true, baseResponse.getCode(), baseResponse.getMessage());
                listener.onError(exceptionHandleUtils);
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        LogUtils.showLogCompletion(TAG, e.toString(), 1000, "verbose");
        dismissProgressDialog();
        // 自定义异常处理
        ExceptionHandleUtils exceptionHandleUtils = ExceptionHandleUtils.handleException(e);
        listener.onError(exceptionHandleUtils);
    }

    private void dismissProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            mProgressDialogHandler = null;
        }
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
    }

    private void showProgressDialog() {
        if (mProgressDialogHandler != null) {
            mProgressDialogHandler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    @Override
    public void onCancelProgress() {
        // 如果处于订阅状态，则取消订阅
        if (d != null) {
            if (!d.isDisposed()) {
                LogUtils.showLogCompletion(TAG, "已取消", 1000, "verbose");
                d.dispose();
            }
        }
    }
}
