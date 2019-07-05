package com.chenyacheng.homecomponent.ui.fragment;

import android.content.Context;

/**
 * 首页页面的View和Model的桥梁
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class HomePresenter extends HomeContract.AbstractPresenter {

    private HomeModel<Object> homeModel;
    private Context context;

    HomePresenter(Context context) {
        this.homeModel = new HomeModel<>();
        this.context = context;
    }


    @Override
    public void home() {

    }
}
