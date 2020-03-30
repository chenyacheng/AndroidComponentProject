package com.chenyacheng.homecomponent.ui.fragment;

import com.chenyacheng.commonlib.base.BasePresenter;
import com.chenyacheng.commonlib.base.BaseView;

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

        /**
         * 测试
         *
         * @param s 传入字符串
         */
        abstract void test(String s);
    }
}
