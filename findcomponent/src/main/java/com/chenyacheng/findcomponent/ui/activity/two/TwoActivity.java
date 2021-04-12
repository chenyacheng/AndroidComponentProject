package com.chenyacheng.findcomponent.ui.activity.two;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;

import com.chenyacheng.commonlib.base.BaseActivity;
import com.chenyacheng.commonlib.base.BasePresenter;
import com.chenyacheng.commonlib.base.BaseView;
import com.chenyacheng.findcomponent.R;
import com.chenyacheng.findcomponent.proxy.Config;
import com.chenyacheng.snackbar.SnackBarBuilder;

/**
 * @author chenyacheng
 * @date 2021/04/08
 */
public class TwoActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.find_two;
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
        Bundle bundle = getIntent().getBundleExtra(Config.KEY_DATA);
        if (bundle != null) {
            String msg = bundle.getString(Config.KEY_MSG);
            if (!TextUtils.isEmpty(msg)) {
                SnackBarBuilder.getInstance().builderShort(this, msg);
            }
        }

        Button clear = findViewById(R.id.find_clear);
        clear.setOnClickListener(v -> Config.isLogin = false);
    }
}
