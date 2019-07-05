package com.chenyacheng.homecomponent.ui.activity.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.chenyacheng.commoblib.base.BaseActivity;
import com.chenyacheng.commoblib.navigationbar.UltimateBar;
import com.chenyacheng.homecomponent.R;
import com.chenyacheng.homecomponent.ui.fragment.HomeFragment;

/**
 * 首页
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class HomeActivity extends BaseActivity {

    private HomeFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_home_main);
        // 设置状态栏
        UltimateBar.Companion.with(this).create().immersionBar();
        ViewPager viewPager = findViewById(R.id.home_main_view_pager);
        // 声明fragment管理
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new HomeFragment();
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
