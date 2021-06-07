package com.chenyacheng.commonlib.progress;

import android.content.Context;

import androidx.annotation.NonNull;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 观察者，实现Observer，监听请求是否成功
 *
 * @author chenyacheng
 * @date 2019/01/17
 */
public class ProgressObserver<T> implements Observer<T>, ProgressCancelListener {

    private final ObserverResponseListener listener;
    private ProgressDialogHandler mProgressDialogHandler;
    private Disposable d;

    public ProgressObserver(Context context, ObserverResponseListener listener, boolean isDialog, boolean cancelable) {
        this.listener = listener;
        if (isDialog) {
            mProgressDialogHandler = new ProgressDialogHandler(context, this, cancelable);
        }
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        this.d = d;
        showProgressDialog();
    }

    @Override
    public void onNext(@NonNull T t) {
        if (null != listener) {
            listener.onSuccess(t);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        dismissProgressDialog();
        if (null != listener) {
            listener.onFail(e);
        }
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
                d.dispose();
                dismissProgressDialog();
            }
        }
    }
}
