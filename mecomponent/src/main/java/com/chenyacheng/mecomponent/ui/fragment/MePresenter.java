package com.chenyacheng.mecomponent.ui.fragment;

import android.content.Context;

/**
 * @author chenyacheng
 * @date 2019/01/21
 */
class MePresenter extends MeContract.AbstractPresenter {

    private MeModel<Object> meModel;
    private Context context;

    MePresenter(Context context) {
        this.meModel = new MeModel<>();
        this.context = context;
    }


    @Override
    public void me() {

    }
}
