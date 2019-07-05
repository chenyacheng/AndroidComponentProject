package com.chenyacheng.findcomponent.ui.fragment;

import android.view.View;

import com.chenyacheng.commoblib.base.BaseLazyFragment;
import com.chenyacheng.commoblib.utils.ToastUtils;
import com.chenyacheng.findcomponent.R;
import com.trello.rxlifecycle2.android.FragmentEvent;

import io.reactivex.ObservableTransformer;

/**
 * 订单列表的状态页面
 *
 * @author chenyacheng
 * @date 2019/02/16
 */
public class FindFragment extends BaseLazyFragment<FindContract.View, FindContract.AbstractPresenter> implements FindContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.find_fragment_find_main;
    }

    @Override
    public FindContract.AbstractPresenter createPresenter() {
        return new FindPresenter(mContext);
    }

    @Override
    public FindContract.View createView() {
        return this;
    }

    @Override
    public void init(View rootView) {

    }

    @Override
    public void findResult() {

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
