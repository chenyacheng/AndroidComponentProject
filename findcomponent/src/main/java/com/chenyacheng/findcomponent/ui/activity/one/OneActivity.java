package com.chenyacheng.findcomponent.ui.activity.one;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.chenyacheng.commonlib.base.BaseActivity;
import com.chenyacheng.commonlib.base.BasePresenter;
import com.chenyacheng.commonlib.base.BaseView;
import com.chenyacheng.commonuilib.utils.InputUtils;
import com.chenyacheng.findcomponent.R;
import com.chenyacheng.findcomponent.proxy.Config;
import com.chenyacheng.findcomponent.proxy.LoginIn;
import com.chenyacheng.findcomponent.proxy.LoginProxy;
import com.chenyacheng.findcomponent.ui.activity.two.TwoActivity;

import java.lang.reflect.Proxy;

/**
 * @author chenyacheng
 * @date 2021/04/08
 */
public class OneActivity extends BaseActivity implements LoginIn {

    private LoginIn launchManagerService;

    @Override
    protected int getLayoutId() {
        return R.layout.find_one;
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

        launchManagerService = (LoginIn) Proxy.newProxyInstance(this.getClassLoader(), new Class[]{LoginIn.class}, new LoginProxy(this,this));
        Button homeBtnOne = findViewById(R.id.find_btn_one);
        homeBtnOne.setOnClickListener(v -> lookMyGoods());
    }

    private void toolBar() {
        initToolBar();
        setHeadToolBarBackground(R.color.common_ffef5214);
        setMiddleTitle("one");
        setLeftDrawable(R.drawable.gray_back_arrow_icon);
        setLeftDrawableClickListener(v -> {
            InputUtils.hideSoftInput(this);
            finish();
        });
    }

    private void lookMyGoods() {
        Intent intent = new Intent(this, TwoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Config.KEY_MSG, "通过登录传递的产品");
        intent.putExtra(Config.KEY_DATA, bundle);
        launchManagerService.startActivity(intent);
    }
}
