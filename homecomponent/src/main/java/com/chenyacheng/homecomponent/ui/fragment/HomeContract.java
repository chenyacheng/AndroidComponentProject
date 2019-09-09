package com.chenyacheng.homecomponent.ui.fragment;

import com.chenyacheng.commoblib.base.BasePresenter;
import com.chenyacheng.commoblib.base.BaseView;

/**
 * 首页页面契约类
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public interface HomeContract {

    interface View extends BaseView {

        /**
         * Renders the viewState
         *
         * @param viewState The current viewState state that should be displayed
         */
        void render(HomeViewState viewState);
    }

    abstract class AbstractPresenter extends BasePresenter<View> {

        /**
         * home请求
         */
        abstract void home();

        abstract void test(String s);
    }
}
