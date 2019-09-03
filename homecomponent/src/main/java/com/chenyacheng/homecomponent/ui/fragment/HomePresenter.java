package com.chenyacheng.homecomponent.ui.fragment;

import android.content.Context;

import com.chenyacheng.commoblib.api.Api;
import com.chenyacheng.commoblib.base.BaseRequest;
import com.chenyacheng.commoblib.progress.ObserverResponseListener;
import com.chenyacheng.commoblib.utils.ExceptionHandleUtils;
import com.chenyacheng.commoblib.utils.GsonUtils;
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
        new BaseRequest().subscribe(context, Api.getApiService().getHomeCall(), true, true, bindAutoDispose(), new ObserverResponseListener() {
            @Override
            public void onNext(Object t) {
                if (null != getView()) {
                    getView().render(new HomeViewState.HomeResult(GsonUtils.removeSpaceFromJson(t, HomeBean.class)));
                }
            }

            @Override
            public void onError(ExceptionHandleUtils e) {
                if (null != getView()) {
                    getView().render(new HomeViewState.Error(e));
                }
            }
        });
    }
}
