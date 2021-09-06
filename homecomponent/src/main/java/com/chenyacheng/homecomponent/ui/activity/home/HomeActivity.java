package com.chenyacheng.homecomponent.ui.activity.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.chenyacheng.commonlib.base.BaseInnerActivity;
import com.chenyacheng.homecomponent.R;
import com.chenyacheng.homecomponent.databinding.HomeActivityHomeMainBinding;
import com.chenyacheng.homecomponent.ui.fragment.HomeFragment;

/**
 * 首页
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class HomeActivity extends BaseInnerActivity {

    private HomeFragment fragment;

    HomeActivityHomeMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_home_main);
        ViewPager viewPager = findViewById(R.id.home_main_view_pager);
        // 声明fragment管理
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new HomeFragment();
        viewPager.setAdapter(new MyFragmentPagerAdapter(fragmentManager));
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
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
