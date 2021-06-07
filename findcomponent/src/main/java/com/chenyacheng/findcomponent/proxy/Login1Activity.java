package com.chenyacheng.findcomponent.proxy;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;

import com.chenyacheng.commonlib.base.BaseActivity;
import com.chenyacheng.commonlib.base.BasePresenter;
import com.chenyacheng.commonlib.base.BaseView;
import com.chenyacheng.findcomponent.R;

/**
 * @author chenyacheng
 * @date 2020/08/12
 */
public class Login1Activity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.find_login_layout;
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
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> handleLoginSuccess3());
    }

    private void handleLoginSuccess3() {
        Bundle bundle = getIntent().getBundleExtra(Config.KEY_DATA);
        String className = bundle.getString(Config.KEY_CLASS_NAME);
        if (TextUtils.isEmpty(className)) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(this, className));
        bundle.remove(Config.KEY_CLASS_NAME);
        intent.putExtra(Config.KEY_DATA, bundle);

        startActivity(intent);
        finish();
        Config.isLogin = true;
    }
}
