package com.chenyacheng.homecomponent.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    private TextView homeTv;
    private TextView homeTvContent;

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
        homeTv = rootView.findViewById(R.id.home_tv);
        homeTvContent = rootView.findViewById(R.id.home_tv_content);
        Button homeBtn = rootView.findViewById(R.id.home_btn);
        homeBtn.setOnClickListener(v -> getPresenter().home());
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void homeResult(HomeModel homeModel) {
        homeTv.setText(homeModel.getTitle());
        homeTvContent.setText(homeModel.getContent());
    }

    @Override
    public void setMsg(String msg) {
        SnackBarBuilder.getInstance().builderShort(mContext, msg);
    }
}
