package com.chenyacheng.commoblib.base;

/**
 * 抽取BaseActivity和BaseLazyFragment的公共方法
 *
 * @author chenyacheng
 * @date 2019/04/19
 */
public interface UiOperation<V, P> {

    /**
     * 返回资源的布局
     *
     * @return 布局
     */
    int getLayoutId();

    /**
     * 创建Presenter
     *
     * @return Presenter
     */
    P createPresenter();

    /**
     * 创建View
     *
     * @return View
     */
    V createView();
}
