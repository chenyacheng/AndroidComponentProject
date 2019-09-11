package com.chenyacheng.homecomponent.ui.activity.b;

import android.widget.Button;

import com.chenyacheng.commoblib.base.BaseActivity;
import com.chenyacheng.commoblib.base.BasePresenter;
import com.chenyacheng.commoblib.base.BaseView;
import com.chenyacheng.commoblib.custom.snack.SnackBarBuilder;
import com.chenyacheng.homecomponent.R;
import com.chenyacheng.homecomponent.model.TestBean;

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
        Button homeBtnTwo = findViewById(R.id.home_btn_two);
        homeBtnTwo.setOnClickListener(v -> {
            TestBean.setReceive(true);
            SnackBarBuilder.getInstance().builderShort(homeBtnTwo, "领取成功");
        });
    }
}
