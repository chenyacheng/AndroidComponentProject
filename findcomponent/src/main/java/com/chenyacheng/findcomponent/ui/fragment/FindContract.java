package com.chenyacheng.findcomponent.ui.fragment;

import com.chenyacheng.commoblib.base.BasePresenter;
import com.chenyacheng.commoblib.base.BaseView;

/**
 * 发现页面契约类
 *
 * @author chenyacheng
 * @date 2019/02/19
 */
public interface FindContract {

    interface View extends BaseView {

        /**
         * Renders the viewState
         *
         * @param viewState The current viewState state that should be displayed
         */
        void render(FindViewState viewState);
    }

    abstract class AbstractPresenter extends BasePresenter<View> {

        /**
         * find请求
         */
        abstract void find();
    }
}
