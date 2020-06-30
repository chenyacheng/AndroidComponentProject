package com.chenyacheng.commonlib.base;

import android.content.Context;

import com.chenyacheng.commonlib.progress.ObserverResponseListener;
import com.chenyacheng.commonlib.progress.ProgressObserver;
import com.uber.autodispose.AutoDisposeConverter;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 封装线程管理和订阅的类
 *
 * @author chenyacheng
 * @date 2019/01/16
 */
public class BaseRequest {

    /**
     * 封装观察者订阅
     *
     * @param context              context上下文
     * @param observable           被观察者的对象
     * @param autoDisposeConverter 取消对Observable订阅，解决RxJava的内存泄漏
     * @param listener             请求监听的对象
     */
    public void subscribe(Context context, final Observable<BaseResponse> observable, AutoDisposeConverter<BaseResponse> autoDisposeConverter, ObserverResponseListener listener) {
        subscribe(context, observable, false, false, autoDisposeConverter, listener);
    }

    /**
     * 封装观察者订阅
     *
     * @param context    context上下文
     * @param observable 被观察者的对象
     * @param listener   请求监听的对象
     * @param isDialog   是否显示dialog
     * @param cancelable 是否取消dialog
     */
    public void subscribe(Context context, final Observable<BaseResponse> observable, boolean isDialog, boolean cancelable, AutoDisposeConverter<BaseResponse> autoDisposeConverter, ObserverResponseListener listener) {
        observable.unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(autoDisposeConverter)
                .subscribe(new ProgressObserver<>(context, listener, isDialog, cancelable));
    }
}
