package com.chenyacheng.commoblib.base;

import android.content.Context;

import com.chenyacheng.commoblib.progress.ObserverResponseListener;
import com.chenyacheng.commoblib.progress.ProgressObserver;
import com.trello.rxlifecycle2.LifecycleTransformer;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 用于封装线程管理和订阅的过程，也可以封装数据库的操作
 *
 * @author chenyacheng
 * @date 2019/01/16
 */
public class BaseModel {

    /**
     * 封装观察者订阅
     *
     * @param context              context上下文
     * @param observable           被观察者的对象
     * @param listener             请求监听的对象
     * @param lifecycleTransformer 取消对Observable订阅
     */
    protected void subscribe(Context context, final Observable<BaseResponse> observable, ObserverResponseListener listener, LifecycleTransformer<Object> lifecycleTransformer) {
        subscribe(context, observable, listener, lifecycleTransformer, false, false);
    }

    /**
     * 封装观察者订阅
     *
     * @param context              context上下文
     * @param observable           被观察者的对象
     * @param listener             请求监听的对象
     * @param lifecycleTransformer 取消对Observable订阅
     * @param isDialog             是否显示dialog
     * @param cancelable           是否取消dialog
     */
    protected void subscribe(Context context, final Observable<BaseResponse> observable, ObserverResponseListener listener, LifecycleTransformer<Object> lifecycleTransformer, boolean isDialog, boolean cancelable) {
        observable.unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                // compose(this.bindToLifecycle())方法绑定Activity的生命周期，在onStart方法中绑定，在onStop方法被调用后就会解除绑定
                // compose方法需要在subscribeOn方法之后使用，因为在测试的过程中发现，将compose方法放在subscribeOn方法之前，如果在被观察者中执行了阻塞方法，比如Thread.sleep()，取消订阅后该阻塞方法不会被中断
                .compose(lifecycleTransformer)
                .subscribe(new ProgressObserver<>(context, listener, isDialog, cancelable));
    }
}
