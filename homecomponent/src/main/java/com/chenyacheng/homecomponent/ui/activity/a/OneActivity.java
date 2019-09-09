package com.chenyacheng.homecomponent.ui.activity.a;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import com.chenyacheng.commoblib.base.BaseActivity;
import com.chenyacheng.commoblib.custom.snack.SnackBarBuilder;
import com.chenyacheng.commoblib.utils.ExceptionHandleUtils;
import com.chenyacheng.homecomponent.R;
import com.chenyacheng.homecomponent.model.TestBean;
import com.chenyacheng.homecomponent.ui.activity.b.TwoActivity;

/**
 * @author Administrator
 * @date 2019/09/09
 */
public class OneActivity extends BaseActivity<OneContract.View, OneContract.AbstractPresenter> implements OneContract.View {

    private TextView homeTvOne;

    @Override
    protected int getLayoutId() {
        return R.layout.home_one;
    }

    @Override
    protected OneContract.AbstractPresenter createPresenter() {
        return new OnePresenter(this);
    }

    @Override
    protected OneContract.View createView() {
        return this;
    }

    @Override
    protected void init() {
        homeTvOne = findViewById(R.id.home_tv_one);
        Button homeBtnOne = findViewById(R.id.home_btn_one);
        homeBtnOne.setOnClickListener(v -> startActivity(new Intent(this, TwoActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().receive();
    }

    @Override
    public void render(OneViewState viewState) {
        if (viewState instanceof OneViewState.Error) {
            renderError(((OneViewState.Error) viewState).getError());
        } else if (viewState instanceof OneViewState.TestResult) {
            renderTest();
        }
    }

    private void renderError(ExceptionHandleUtils error) {
        SnackBarBuilder.getInstance().builderShort(this, error.message);
    }

    private void renderTest() {
        if (TestBean.isReceive()) {
            homeTvOne.setText("领取状态:已领取");
        } else {
            homeTvOne.setText("领取状态:未领取");
        }
    }
}
