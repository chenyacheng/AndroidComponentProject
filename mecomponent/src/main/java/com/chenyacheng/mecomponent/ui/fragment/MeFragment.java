package com.chenyacheng.mecomponent.ui.fragment;

import android.view.View;

import com.chenyacheng.commoblib.base.BaseLazyFragment;
import com.chenyacheng.commoblib.utils.ToastUtils;
import com.chenyacheng.mecomponent.R;
import com.trello.rxlifecycle2.android.FragmentEvent;

import io.reactivex.ObservableTransformer;

/**
 * fragment我的
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class MeFragment extends BaseLazyFragment<MeContract.View, MeContract.AbstractPresenter> implements MeContract.View {


    @Override
    public int getLayoutId() {
        return R.layout.me_fragment_me_main;
    }

    @Override
    public MeContract.AbstractPresenter createPresenter() {
        return new MePresenter(mContext);
    }

    @Override
    public MeContract.View createView() {
        return this;
    }

    @Override
    public void init(View rootView) {

    }

    @Override
    public void meResult() {

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
