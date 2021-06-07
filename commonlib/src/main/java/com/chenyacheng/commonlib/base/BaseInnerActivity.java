package com.chenyacheng.commonlib.base;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chenyacheng.commonlib.R;
import com.chenyacheng.commonlib.utils.StatusBarUtils;

/**
 * 基本内部类
 *
 * @author chenyacheng
 * @date 2019/07/04
 */
public abstract class BaseInnerActivity extends AppCompatActivity {

    /**
     * 导航栏背景
     */
    private FrameLayout frameLayout;
    /**
     * 左侧图标
     */
    private ImageView ivLeftIcon;
    /**
     * 左侧图标点击事件
     */
    private FrameLayout flLeft;
    /**
     * 中间Title
     */
    private TextView tvMiddleTitle;
    /**
     * 右侧文字
     */
    private TextView tvRight;
    /**
     * 右侧点击事件
     */
    private FrameLayout flRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.makeStatusBarTransparent(this);
        StatusBarUtils.setStatusBarLightMode(this, false);
    }

    public void initToolBar() {
        frameLayout = findViewById(R.id.frame_layout);
        ivLeftIcon = findViewById(R.id.iv_left_icon);
        flLeft = findViewById(R.id.fl_left);
        tvMiddleTitle = findViewById(R.id.tv_middle_title);
        tvRight = findViewById(R.id.tv_right);
        flRight = findViewById(R.id.fl_right);
    }

    /**
     * 设置导航栏背景颜色
     *
     * @param resId 资源Id
     */
    public void setHeadToolBarBackground(int resId) {
        frameLayout.setBackgroundResource(resId);
    }

    /**
     * 设置左侧图标
     *
     * @param resId 图标Id
     */
    public void setLeftDrawable(int resId) {
        flLeft.setVisibility(View.VISIBLE);
        ivLeftIcon.setImageResource(resId);
    }

    /**
     * 设置左侧图标点击事件
     *
     * @param onClickListener 点击事件
     */
    public void setLeftDrawableClickListener(View.OnClickListener onClickListener) {
        flLeft.setOnClickListener(onClickListener);
    }

    /**
     * 设置中间的title
     *
     * @param title 标题
     */
    public void setMiddleTitle(String title) {
        tvMiddleTitle.setVisibility(View.VISIBLE);
        tvMiddleTitle.setText(title);
    }

    /**
     * 设置文字颜色
     *
     * @param textColor 文字颜色
     */
    public void setMiddleTitleColor(int textColor) {
        tvMiddleTitle.setTextColor(textColor);
    }

    /**
     * 设置右侧文字
     *
     * @param text 文字
     */
    public void setRightText(String text) {
        flRight.setVisibility(View.VISIBLE);
        tvRight.setText(text);
    }

    /**
     * 设置右侧文字大小
     *
     * @param unit     字体大小单位
     * @param textSize 文字大小
     */
    public void setRightTextSize(int unit, float textSize) {
        flRight.setVisibility(View.VISIBLE);
        tvRight.setTextSize(unit, textSize);
    }

    /**
     * 设置右侧文字颜色
     *
     * @param textColor 文字颜色
     */
    public void setRightTextColor(int textColor) {
        flRight.setVisibility(View.VISIBLE);
        tvRight.setTextColor(textColor);
    }

    /**
     * 设置右侧文字背景
     *
     * @param resId  文字背景Id
     * @param left   左边内边距
     * @param top    上边内边距
     * @param right  右边内边距
     * @param bottom 下边内边距
     */
    public void setRightTextBarBackground(int resId, int left, int top, int right, int bottom) {
        flRight.setVisibility(View.VISIBLE);
        tvRight.setBackgroundResource(resId);
        tvRight.setPadding(left, top, right, bottom);
    }

    /**
     * 设置右侧点击事件
     *
     * @param onClickListener 点击事件
     */
    public void setRightClickListener(View.OnClickListener onClickListener) {
        flRight.setOnClickListener(onClickListener);
    }
}
