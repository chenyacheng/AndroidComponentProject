package com.chenyacheng.commonlib.base;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 封装presenter，用于view绑定与解绑
 *
 * @author chenyacheng
 * @date 2019/01/16
 */
public abstract class BasePresenter<V extends BaseView> {

    private V mView;
    /**
     * 弱引用, 防止内存泄漏
     */
    private WeakReference<V> weakReference;

    public V getView() {
        return mView;
    }

    /**
     * view需要的时候就绑定p层
     *
     * @param v View的对象
     */
    @SuppressWarnings("unchecked")
    void attachView(V v) {
        weakReference = new WeakReference<>(v);
        ViewHandler viewHandler = new ViewHandler(weakReference.get());
        mView = (V) Proxy.newProxyInstance(v.getClass().getClassLoader(), v.getClass().getInterfaces(), viewHandler);
    }

    private boolean isViewAttached() {
        return weakReference != null && weakReference.get() != null;
    }

    /**
     * view销毁的时候就与p层解绑
     */
    void detachView() {
        if (isViewAttached()) {
            weakReference.clear();
            weakReference = null;
        }
    }

    protected <T> AutoDisposeConverter<T> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mView));
    }

    private class ViewHandler implements InvocationHandler {

        private BaseView view;

        ViewHandler(BaseView view) {
            this.view = view;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 如果V层没被销毁, 执行V层的方法.
            if (isViewAttached()) {
                return method.invoke(view, args);
            }
            // P层不需要关注V层的返回值
            return null;
        }
    }
}
