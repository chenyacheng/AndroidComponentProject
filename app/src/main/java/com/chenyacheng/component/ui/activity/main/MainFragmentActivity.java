package com.chenyacheng.component.ui.activity.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chenyacheng.commonlib.base.BaseInnerActivity;
import com.chenyacheng.commonuilib.constant.RouterConstant;
import com.chenyacheng.commonuilib.widget.CustomViewPager;
import com.chenyacheng.component.R;
import com.chenyacheng.findcomponent.ui.fragment.FindFragment;
import com.chenyacheng.homecomponent.ui.fragment.HomeFragment;
import com.chenyacheng.mecomponent.ui.fragment.MeFragment;
import com.chenyacheng.snackbar.SnackBarBuilder;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页面：首页+发现+我的
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
@Route(path = RouterConstant.PATH_APP_MAIN_ACTIVITY)
public class MainFragmentActivity extends BaseInnerActivity {

    private final List<Fragment> fragmentList = new ArrayList<>();
    /**
     * 第一次按下返回键的时间
     */
    private long lastBackPressedTime = 0;
    private final String[] titles = {"首页", "发现", "我的"};
    private final int[] colors = {R.color.common_FF1296DB, R.color.common_ff333333};
    private final int[] normalIcon = {R.drawable.home_icon_normal, R.drawable.find_icon_normal, R.drawable.me_icon_normal};
    private final int[] selectedIcon = {R.drawable.home_icon_selected, R.drawable.find_icon_selected, R.drawable.me_icon_selected};
    /**
     * 选项卡的各个选项的TextView的集合：用于切换时改变图标和文字颜色
     */
    private final List<TextView> bottomTabChecked = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CustomViewPager viewPager = findViewById(R.id.main_view_pager);
        fragmentList.add(new HomeFragment());
        fragmentList.add(new FindFragment());
        fragmentList.add(new MeFragment());
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setScanScroll(false);
        viewPager.setOffscreenPageLimit(fragmentList.size());
        TabLayout mTabLayout = findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < mTabLayout.getTabCount(); ++i) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(getTabView(i));
            }
        }
        // 设置第一选项卡为选中状态
        setTextAndIconColor(0, true);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setTextAndIconColor(tab.getPosition(), true);
                viewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                setTextAndIconColor(tab.getPosition(), false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private View getTabView(int curPos) {
        View view = View.inflate(this, R.layout.tab_main_bottom_layout, null);
        TextView tv = view.findViewById(R.id.tab_item_tv);
        tv.setText(titles[curPos]);
        Drawable drawableIcon = ResourcesCompat.getDrawable(getResources(), normalIcon[curPos], null);
        if (null != drawableIcon) {
            drawableIcon.setBounds(0, 0, drawableIcon.getMinimumWidth(), drawableIcon.getMinimumHeight());
            tv.setCompoundDrawables(null, drawableIcon, null, null);
        }
        bottomTabChecked.add(tv);
        return view;
    }

    private void setTextAndIconColor(int i, boolean select) {
        bottomTabChecked.get(i).setTextColor(ContextCompat.getColor(this, select ? colors[0] : colors[1]));
        Drawable drawableIcon = ResourcesCompat.getDrawable(getResources(), select ? selectedIcon[i] : normalIcon[i], null);
        if (null != drawableIcon) {
            drawableIcon.setBounds(0, 0, drawableIcon.getMinimumWidth(), drawableIcon.getMinimumHeight());
            bottomTabChecked.get(i).setCompoundDrawables(null, drawableIcon, null, null);
        }
    }

    @Override
    public void onBackPressed() {
        // 按下返回键的时间间隔
        final int backPressedInterval = 2000;
        // 与上次点击返回键时刻作差
        if ((System.currentTimeMillis() - lastBackPressedTime) > backPressedInterval) {
            // 大于2000ms则认为是误操作，使用Toast进行提示
            SnackBarBuilder.getInstance().builderShort(this, "再按一次退出程序");
            // 并记录下本次点击“返回键”的时刻，以便下次进行判断
            lastBackPressedTime = System.currentTimeMillis();
        } else {
            SnackBarBuilder.getInstance().hideView();
            // 小于2000ms，App切入后台
            if (!moveTaskToBack(false)) {
                // 非根Activity，切入后台失败，执行返回操作
                super.onBackPressed();
            }
        }
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }
}
