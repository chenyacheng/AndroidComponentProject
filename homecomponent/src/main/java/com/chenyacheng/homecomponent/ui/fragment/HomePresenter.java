package com.chenyacheng.homecomponent.ui.fragment;

import android.content.Context;

import com.chenyacheng.commonlib.base.BaseApi;
import com.chenyacheng.commonlib.base.BaseRequest;
import com.chenyacheng.commonuilib.ResponseDataFormat;
import com.chenyacheng.commonuilib.ResponseListener;
import com.chenyacheng.commonuilib.api.ApiService;
import com.chenyacheng.commonuilib.config.AppConfig;
import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;
import com.chenyacheng.commonuilib.utils.GsonUtils;
import com.chenyacheng.commonuilib.utils.LogUtils;
import com.chenyacheng.homecomponent.model.HomeBean;

/**
 * 首页页面的View和Model的桥梁
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class HomePresenter extends HomeContract.AbstractPresenter {

    private Context context;

    HomePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void home() {
        new BaseRequest().subscribe(context, BaseApi.getInstance().getRetrofit(AppConfig.BASE_URL).create(ApiService.class).getHomeCall(),
                true, true, bindAutoDispose(), new ResponseDataFormat(new ResponseListener() {
                    @Override
                    public void onSuccess(Object t) {
                        LogUtils.verbose("------------------",t.toString());
                        getView().render(new HomeViewState.HomeResult(GsonUtils.removeSpaceFromJson(t, HomeBean.class)));
                    }

                    @Override
                    public void onFail(ExceptionHandleUtils e) {
                        getView().render(new HomeViewState.Error(e));
                    }
                }));
    }

    @Override
    void test(String s) {
        getView().render(new HomeViewState.TestResult(s));
    }
}
