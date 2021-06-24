package com.chenyacheng.homecomponent.ui.activity.a;

import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chenyacheng.commonlib.base.BaseActivity;
import com.chenyacheng.commonuilib.constant.RouterConstant;
import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;
import com.chenyacheng.commonuilib.utils.InputUtils;
import com.chenyacheng.homecomponent.R;
import com.chenyacheng.homecomponent.model.TestBean;
import com.chenyacheng.snackbar.SnackBarBuilder;

/**
 * @author chenyacheng
 * @date 2019/09/09
 */
@Route(path = RouterConstant.PATH_HOME_ONE_ACTIVITY)
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
        toolBar();
        homeTvOne = findViewById(R.id.home_tv_one);
        Button homeBtnOne = findViewById(R.id.home_btn_one);
        homeBtnOne.setOnClickListener(v -> ARouter.getInstance().build(RouterConstant.PATH_HOME_TWO_ACTIVITY).navigation());
    }

    private void toolBar() {
        initToolBar();
        setHeadToolBarBackground(R.color.common_ffef5214);
        setMiddleTitle("页面1");
        setLeftDrawable(R.drawable.gray_back_arrow_icon);
        setLeftDrawableClickListener(v -> {
            InputUtils.hideSoftInput(this);
            finish();
        });
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
