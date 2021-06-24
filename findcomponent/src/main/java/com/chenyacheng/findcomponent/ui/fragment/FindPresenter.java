package com.chenyacheng.findcomponent.ui.fragment;

import android.content.Context;

import com.chenyacheng.commonlib.base.BaseApi;
import com.chenyacheng.commonlib.base.BaseRequest;
import com.chenyacheng.commonuilib.base.ResponseDataFormat;
import com.chenyacheng.commonuilib.base.ResponseListener;
import com.chenyacheng.commonuilib.config.AppConfig;
import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;
import com.chenyacheng.commonuilib.utils.GsonUtils;
import com.chenyacheng.findcomponent.api.FindService;
import com.chenyacheng.findcomponent.model.FindBean;

/**
 * 订单列表状态页面的View和Model的桥梁
 *
 * @author chenyacheng
 * @date 2019/02/19
 */
class FindPresenter extends FindContract.AbstractPresenter {

    private final Context context;

    FindPresenter(Context context) {
        this.context = context;
    }

    @Override
    void find() {
        new BaseRequest().subscribe(context, BaseApi.getInstance().getRetrofit(AppConfig.BASE_URL).create(FindService.class).getFindCall(),
                true, true, bindAutoDispose(), new ResponseDataFormat(new ResponseListener() {
                    @Override
                    public void onSuccess(Object t) {
                        getView().render(new FindViewState.FindResult(GsonUtils.removeSpaceFromJson(t, FindBean.class)));
                    }

                    @Override
                    public void onFail(ExceptionHandleUtils e) {
                        getView().render(new FindViewState.Error(e));
                    }
                }));
    }
}
