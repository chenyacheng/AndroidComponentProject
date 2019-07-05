package com.chenyacheng.mecomponent.ui.activity.me;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.chenyacheng.commoblib.base.BaseActivity;
import com.chenyacheng.commoblib.navigationbar.UltimateBar;
import com.chenyacheng.mecomponent.R;
import com.chenyacheng.mecomponent.ui.fragment.MeFragment;


/**
 * 我的
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class MeActivity extends BaseActivity {

    private MeFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_activity_me_main);
        // 设置状态栏
        UltimateBar.Companion.with(this).create().immersionBar();
        ViewPager viewPager = findViewById(R.id.me_view_pager);
        // 声明fragment管理
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new MeFragment();
        viewPager.setAdapter(new MyFragmentPagerAdapter(fragmentManager));
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragment;
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}
