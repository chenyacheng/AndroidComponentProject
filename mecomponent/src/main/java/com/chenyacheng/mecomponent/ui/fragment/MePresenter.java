package com.chenyacheng.mecomponent.ui.fragment;

import android.content.Context;

import com.chenyacheng.commonlib.base.BaseApi;
import com.chenyacheng.commonlib.base.BaseRequest;
import com.chenyacheng.commonuilib.base.ResponseDataFormat;
import com.chenyacheng.commonuilib.base.ResponseListener;
import com.chenyacheng.commonuilib.config.AppConfig;
import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;
import com.chenyacheng.commonuilib.utils.GsonUtils;
import com.chenyacheng.mecomponent.me.MeService;
import com.chenyacheng.mecomponent.model.MeBean;

/**
 * @author chenyacheng
 * @date 2019/01/21
 */
class MePresenter extends MeContract.AbstractPresenter {

    private final Context context;

    MePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void me() {
        new BaseRequest().subscribe(context, BaseApi.getInstance().getRetrofit(AppConfig.BASE_URL).create(MeService.class).getMeCall(),
                bindAutoDispose(), new ResponseDataFormat(new ResponseListener() {
                    @Override
                    public void onSuccess(Object t) {
                        getView().render(new MeViewState.MeResult(GsonUtils.removeSpaceFromJson(t, MeBean.class)));
                    }

                    @Override
                    public void onFail(ExceptionHandleUtils e) {
                        getView().render(new MeViewState.Error(e));
                    }
                }));
    }
}
