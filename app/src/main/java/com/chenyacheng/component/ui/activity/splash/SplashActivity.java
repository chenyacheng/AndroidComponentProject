package com.chenyacheng.component.ui.activity.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.chenyacheng.commonlib.base.BaseInnerActivity;
import com.chenyacheng.component.R;
import com.chenyacheng.component.ui.activity.main.MainFragmentActivity;

/**
 * 启动页
 *
 * @author chenyacheng
 * @date 2019/04/11
 */
public class SplashActivity extends BaseInnerActivity implements Handler.Callback {

    private Handler mHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 休眠1000毫秒后进入主界面
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    @Override
    protected void onPause() {
        // 防止启动界面退出后过一会又进入登录页面
        mHandler.removeMessages(0);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
        mHandler = null;
        super.onDestroy();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        startActivity(new Intent(this, MainFragmentActivity.class));
        finish();
        overridePendingTransition(R.anim.activity_fade_enter, R.anim.activity_fade_exit);
        return true;
    }
}
