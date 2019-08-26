package com.chenyacheng.homecomponent.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProviders;

import com.chenyacheng.commoblib.base.BaseLazyFragment;
import com.chenyacheng.commoblib.custom.snack.SnackBarBuilder;
import com.chenyacheng.homecomponent.R;

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
        // 构建ViewModel对象
        final HomeViewModel model = ViewModelProviders.of(this).get(HomeViewModel.class);
        TextView homeTv = rootView.findViewById(R.id.home_tv);
        Button homeBtn = rootView.findViewById(R.id.home_btn);
        homeBtn.setOnClickListener(view -> model.getContentData());
        model.getContent().observe(this, homeTv::setText);

       
    }

    @Override
    public void homeResult() {

    }

    @Override
    public void setMsg(String msg) {
        SnackBarBuilder.getInstance().builderShort(mContext, msg);
    }
}
