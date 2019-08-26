package com.chenyacheng.findcomponent.ui.activity.find;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.chenyacheng.commoblib.base.BaseInnerActivity;
import com.chenyacheng.commoblib.navigationbar.UltimateBar;
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
        // 设置状态栏
        Drawable statusDrawable = new ColorDrawable(ContextCompat.getColor(this, R.color.common_ffffffff));
        Drawable statusDrawable2 = new ColorDrawable(ContextCompat.getColor(this, R.color.common_ff000000));
        UltimateBar.Companion.with(this)
                .statusDark(true)
                .statusDrawable(statusDrawable)
                .statusDrawable2(statusDrawable2)
                .create()
                .drawableBar();
        ViewPager viewPager = findViewById(R.id.order_list_view_pager);
        // 声明fragment管理
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new FindFragment();
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
