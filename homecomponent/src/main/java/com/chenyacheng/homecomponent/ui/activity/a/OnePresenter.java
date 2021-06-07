package com.chenyacheng.homecomponent.ui.activity.a;

import android.content.Context;

import com.chenyacheng.homecomponent.model.TestBean;

/**
 * @author chenyacheng
 * @date 2019/09/09
 */
class OnePresenter extends OneContract.AbstractPresenter {

    private final Context context;

    OnePresenter(Context context) {
        this.context = context;
    }

    @Override
    void receive() {
        getView().render(new OneViewState.TestResult(TestBean.isReceive()));
    }
}
