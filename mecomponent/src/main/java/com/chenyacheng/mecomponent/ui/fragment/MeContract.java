package com.chenyacheng.mecomponent.ui.fragment;

import com.chenyacheng.commonlib.base.BasePresenter;
import com.chenyacheng.commonlib.base.BaseView;

/**
 * 首页页面契约类
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public interface MeContract {

    interface View extends BaseView {

        /**
         * Renders the viewState
         *
         * @param viewState The current viewState state that should be displayed
         */
        void render(MeViewState viewState);
    }

    abstract class AbstractPresenter extends BasePresenter<View> {

        /**
         * me请求
         */
        abstract void me();
    }
}
