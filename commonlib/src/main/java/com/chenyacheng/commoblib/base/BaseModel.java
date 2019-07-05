package com.chenyacheng.commoblib.base;

import android.content.Context;

import com.chenyacheng.commoblib.progress.ObserverResponseListener;
import com.chenyacheng.commoblib.progress.ProgressObserver;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 用于封装线程管理和订阅的过程，也可以封装数据库的操作
 *
 * @author chenyacheng
 * @date 2019/01/16
 */
public class BaseModel<T> {
    /**
     * 封装观察者订阅
     *
     * @param context     context上下文
     * @param observable  被观察者的对象
     * @param listener    请求监听的对象
     * @param transformer transformer
     */
    protected void subscribe(Context context, final Observable<T> observable, ObserverResponseListener listener, ObservableTransformer<T, T> transformer) {
        subscribe(context, observable, listener, transformer, false, false);
    }

    /**
     * 封装观察者订阅
     *
     * @param context     context上下文
     * @param observable  被观察者的对象
     * @param listener    请求监听的对象
     * @param transformer transformer
     * @param isDialog    是否显示dialog
     * @param cancelable  是否取消dialog
     */
    protected void subscribe(Context context, final Observable<T> observable, ObserverResponseListener listener, ObservableTransformer<T, T> transformer, boolean isDialog, boolean cancelable) {
        final Observer<T> observer = new ProgressObserver<>(context, listener, isDialog, cancelable);
        observable.compose(transformer)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
