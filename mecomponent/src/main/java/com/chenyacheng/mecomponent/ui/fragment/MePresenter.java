package com.chenyacheng.mecomponent.ui.fragment;

import android.content.Context;

import com.chenyacheng.commonlib.api.Api;
import com.chenyacheng.commonlib.base.BaseRequest;
import com.chenyacheng.commonlib.progress.ObserverResponseListener;
import com.chenyacheng.commonlib.utils.ExceptionHandleUtils;
import com.chenyacheng.commonlib.utils.GsonUtils;
import com.chenyacheng.mecomponent.model.MeBean;

/**
 * @author chenyacheng
 * @date 2019/01/21
 */
class MePresenter extends MeContract.AbstractPresenter {

    private Context context;

    MePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void me() {
        new BaseRequest().subscribe(context, Api.getApiService().getMeCall(), bindAutoDispose(), new ObserverResponseListener() {
            @Override
            public void onNext(Object t) {
                if (null != getView()) {
                    getView().render(new MeViewState.MeResult(GsonUtils.removeSpaceFromJson(t, MeBean.class)));
                }
            }

            @Override
            public void onError(ExceptionHandleUtils e) {
                if (null != getView()) {
                    getView().render(new MeViewState.Error(e));
                }
            }
        });
    }
}
