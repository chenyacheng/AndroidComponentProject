package com.chenyacheng.findcomponent.ui.fragment;

import android.content.Context;

import com.chenyacheng.commonlib.api.Api;
import com.chenyacheng.commonlib.base.BaseRequest;
import com.chenyacheng.commonlib.progress.ObserverResponseListener;
import com.chenyacheng.commonlib.utils.ExceptionHandleUtils;
import com.chenyacheng.commonlib.utils.GsonUtils;
import com.chenyacheng.findcomponent.model.FindBean;

/**
 * 订单列表状态页面的View和Model的桥梁
 *
 * @author chenyacheng
 * @date 2019/02/19
 */
class FindPresenter extends FindContract.AbstractPresenter {

    private Context context;

    FindPresenter(Context context) {
        this.context = context;
    }


    @Override
    void find() {
        new BaseRequest().subscribe(context, Api.getApiService().getFindCall(), true, true, bindAutoDispose(), new ObserverResponseListener() {
            @Override
            public void onNext(Object t) {
                if (null != getView()) {
                    getView().render(new FindViewState.FindResult(GsonUtils.removeSpaceFromJson(t, FindBean.class)));
                }
            }

            @Override
            public void onError(ExceptionHandleUtils e) {
                if (null != getView()) {
                    getView().render(new FindViewState.Error(e));
                }
            }
        });
    }
}
