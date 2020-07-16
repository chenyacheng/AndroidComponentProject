package com.chenyacheng.homecomponent.ui.activity.b;

import android.widget.Button;

import com.chenyacheng.commonlib.base.BaseActivity;
import com.chenyacheng.commonlib.base.BasePresenter;
import com.chenyacheng.commonlib.base.BaseView;
import com.chenyacheng.commonuilib.utils.InputUtils;
import com.chenyacheng.commonlib.utils.StatusBarUtils;
import com.chenyacheng.homecomponent.R;
import com.chenyacheng.homecomponent.model.TestBean;
import com.chenyacheng.snackbar.SnackBarBuilder;

/**
 * @author Administrator
 * @date 2019/09/09
 */
public class TwoActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.home_two;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected BaseView createView() {
        return null;
    }

    @Override
    protected void init() {
        toolBar();
        StatusBarUtils.setStatusBarLightMode(this, true);
        Button homeBtnTwo = findViewById(R.id.home_btn_two);
        homeBtnTwo.setOnClickListener(v -> {
            TestBean.setReceive(true);
            SnackBarBuilder.getInstance().builderShort(homeBtnTwo, "领取成功");
        });
    }

    private void toolBar() {
        initToolBar();
        setHeadToolBarBackground(R.color.common_ff00ff00);
        setMiddleTitle("页面2222222222");
        setLeftDrawable(R.drawable.gray_back_arrow_icon);
        setLeftDrawableClickListener(v -> {
            InputUtils.hideSoftInput(this);
            finish();
        });
    }
}
