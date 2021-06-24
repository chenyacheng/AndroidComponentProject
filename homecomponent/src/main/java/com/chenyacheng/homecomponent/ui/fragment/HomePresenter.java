package com.chenyacheng.homecomponent.ui.fragment;

import android.content.Context;

import com.chenyacheng.commonlib.base.BaseApi;
import com.chenyacheng.commonlib.base.BaseRequest;
import com.chenyacheng.commonuilib.base.ResponseDataFormat;
import com.chenyacheng.commonuilib.base.ResponseListener;
import com.chenyacheng.commonuilib.config.AppConfig;
import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;
import com.chenyacheng.commonuilib.utils.GsonUtils;
import com.chenyacheng.homecomponent.api.HomeService;
import com.chenyacheng.homecomponent.model.HomeBean;

/**
 * 首页页面的View和Model的桥梁
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class HomePresenter extends HomeContract.AbstractPresenter {

    private final Context context;

    HomePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void home() {
        String name = "张三";
        String sex = "男";
        String mobile = "1311193346";
        HomeBean homeBean = new HomeBean();
        homeBean.setName(name);
        homeBean.setSex(sex);
        homeBean.setMobile(mobile);
        new BaseRequest().subscribe(context, BaseApi.getInstance().getRetrofit(AppConfig.BASE_URL).create(HomeService.class).getHomeCall(homeBean),
                true, true, bindAutoDispose(), new ResponseDataFormat(new ResponseListener() {
                    @Override
                    public void onSuccess(Object t) {
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
