package com.chenyacheng.homecomponent.ui.fragment;

import android.view.View;

import com.chenyacheng.commoblib.base.BaseLazyFragment;
import com.chenyacheng.commoblib.utils.ToastUtils;
import com.chenyacheng.homecomponent.R;
import com.trello.rxlifecycle2.android.FragmentEvent;

import io.reactivex.ObservableTransformer;

/**
 * fragment首页
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class HomeFragment extends BaseLazyFragment<HomeContract.View, HomeContract.AbstractPresenter> implements HomeContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment_home_main;
    }

    @Override
    public HomeContract.AbstractPresenter createPresenter() {
        return new HomePresenter(mContext);
    }

    @Override
    public HomeContract.View createView() {
        return this;
    }


    @Override
    public void init(View rootView) {

    }

    @Override
    public void homeResult() {

    }

    @Override
    public void setMsg(String msg) {
        ToastUtils.showShortToast(msg);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindUntilEvent(FragmentEvent.PAUSE);
    }
}
