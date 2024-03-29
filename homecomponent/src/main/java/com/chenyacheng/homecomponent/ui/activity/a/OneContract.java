package com.chenyacheng.homecomponent.ui.activity.a;

import com.chenyacheng.commonlib.base.BasePresenter;
import com.chenyacheng.commonlib.base.BaseView;

/**
 * @author chenyacheng
 * @date 2019/09/09
 */
public interface OneContract {

    interface View extends BaseView {

        /**
         * Renders the viewState
         *
         * @param viewState The current viewState state that should be displayed
         */
        void render(OneViewState viewState);
    }

    abstract class AbstractPresenter extends BasePresenter<View> {

        /**
         * 领取
         */
        abstract void receive();
    }
}
