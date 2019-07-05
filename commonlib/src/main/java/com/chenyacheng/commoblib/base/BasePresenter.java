package com.chenyacheng.commoblib.base;

/**
 * 封装presenter，用于view绑定与解绑
 *
 * @author chenyacheng
 * @date 2019/01/16
 */
public abstract class BasePresenter<V extends BaseView> {

    private V mView;

    public V getView() {
        return mView;
    }

    /**
     * view需要的时候就绑定p层
     *
     * @param v View的对象
     */
    void attachView(V v) {
        mView = v;
    }

    /**
     * view销毁的时候就与p层解绑
     */
    void detachView() {
        mView = null;
    }
}
