package com.chenyacheng.commonlib.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * 父类->基类->动态指定类型->泛型设计（通过泛型指定动态类型->由子类指定，父类只需要规定范围即可）
 *
 * @author chenyacheng
 * @date 2019/01/16
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseInnerActivity {
    /**
     * 引用P层
     */
    private P presenter;
    /**
     * 引用V层
     */
    private V view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (presenter == null) {
            presenter = createPresenter();
        }
        if (view == null) {
            view = createView();
        }
        if (presenter != null && view != null) {
            presenter.attachView(view);
        }
        init();
    }

    /**
     * 返回资源的布局
     *
     * @return 布局
     */
    protected abstract int getLayoutId();

    /**
     * 创建Presenter
     *
     * @return Presenter
     */
    protected abstract P createPresenter();

    /**
     * 创建View
     *
     * @return View
     */
    protected abstract V createView();

    /**
     * 初始化
     */
    protected abstract void init();

    /**
     * 在activity销毁时，将p层与v视图解绑
     */
    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroy();
    }

    protected P getPresenter() {
        return presenter;
    }
}
