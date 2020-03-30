package com.chenyacheng.findcomponent.ui.activity.find;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.chenyacheng.commoblib.base.BaseInnerActivity;
import com.chenyacheng.findcomponent.R;
import com.chenyacheng.findcomponent.ui.fragment.FindFragment;

/**
 * 发现
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class FindActivity extends BaseInnerActivity {

    private FindFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_activity_find_main);
        ViewPager viewPager = findViewById(R.id.order_list_view_pager);
        // 声明fragment管理
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new FindFragment();
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
