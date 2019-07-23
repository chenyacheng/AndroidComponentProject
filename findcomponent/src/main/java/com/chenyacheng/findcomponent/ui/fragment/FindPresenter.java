package com.chenyacheng.findcomponent.ui.fragment;

import android.content.Context;

/**
 * 订单列表状态页面的View和Model的桥梁
 *
 * @author chenyacheng
 * @date 2019/02/19
 */
class FindPresenter extends FindContract.AbstractPresenter {

    private FindModel orderListStatusModel;
    private Context context;

    FindPresenter(Context context) {
        this.orderListStatusModel = new FindModel();
        this.context = context;
    }


    @Override
    void find() {

    }
}
