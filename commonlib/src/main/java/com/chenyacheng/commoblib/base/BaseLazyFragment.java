package com.chenyacheng.commoblib.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chenyacheng.commoblib.utils.LogUtils;

/**
 * 父类->基类->动态指定类型->泛型设计（通过泛型指定动态类型->由子类指定，父类只需要规定范围即可）
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public abstract class BaseLazyFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment implements UiOperation<V, P> {

    public Activity mContext;
    /**
     * 引用V层和P层
     */
    private P presenter;
    private V view;
    private View rootView;
    /**
     * 当前Fragment是否首次可见，默认是首次可见
     */
    private boolean mIsFirstVisible = true;
    /**
     * 当前Fragment的View是否已经创建
     */
    private boolean isViewCreated = false;
    /**
     * 当前Fragment的可见状态，一种当前可见，一种当前不可见
     */
    private boolean currentVisibleState = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtils.showLogCompletion("----->", String.valueOf(isVisibleToUser), 1000, "verbose");
        if (isViewCreated) {
            // Fragment可见且状态不是可见(从一个Fragment切换到另外一个Fragment,后一个设置状态为可见)
            if (isVisibleToUser && !currentVisibleState) {
                disPatchFragment(true);
            } else if (!isVisibleToUser && currentVisibleState) {
                // Fragment不可见且状态是可见(从一个Fragment切换到另外一个Fragment,前一个更改状态为不可见)
                disPatchFragment(false);
            }
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtils.showLogCompletion("-----> onCreateView", "-----> onCreateView", 1000, "verbose");
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
            mContext = getActivity();
            if (presenter == null) {
                presenter = createPresenter();
            }
            if (this.view == null) {
                this.view = createView();
            }
            if (presenter != null && view != null) {
                presenter.attachView(this.view);
            }
            init(rootView);
        }
        // 在onCreateView执行完毕，将isViewCreated改为true
        isViewCreated = true;
        return rootView;
    }

    /**
     * 初始化
     *
     * @param rootView rootView
     */
    public abstract void init(View rootView);

    /**
     * @param visible Fragment当前是否可见，然后调用相关方法
     */
    private void disPatchFragment(boolean visible) {
        currentVisibleState = visible;
        // Fragment可见
        if (visible) {
            // 可见又是第一次
            if (mIsFirstVisible) {
                // 改变首次可见的状态
                mIsFirstVisible = false;
                onFragmentFirst();
            } else {
                // 可见但不是第一次
                onFragmentVisible();
            }
        } else {
            // 不可见
            onFragmentInvisibility();
        }
    }

    /**
     * fragment首次可见的方法
     */
    private void onFragmentFirst() {
        LogUtils.showLogCompletion("onFragmentFirst", "首次可见", 1000, "verbose");
    }

    /**
     * fragment可见的方法
     */
    private void onFragmentVisible() {
        // 子Fragment调用次方法，执行可见操作
        LogUtils.showLogCompletion("onFragmentVisibility", "可见", 1000, "verbose");
    }

    /**
     * fragment不可见的方法
     */
    private void onFragmentInvisibility() {
        LogUtils.showLogCompletion("onFragmentInvisibility", "不可见", 1000, "verbose");
    }

    public P getPresenter() {
        return presenter;
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.showLogCompletion("onStart", "onStart", 1000, "verbose");
        // isHidden()是Fragment是否处于隐藏状态和isVisible()有区别
        // getUserVisibleHint(),Fragment是否可见
        // 如果Fragment没有隐藏且可见
        if (!isHidden() && getUserVisibleHint()) {
            // 执行分发的方法,三种结果对应自Fragment的三个回调，对应的操作，Fragment首次加载，可见，不可见
            disPatchFragment(true);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.showLogCompletion("-----> onResume", "-----> onResume", 1000, "verbose");
        if (!mIsFirstVisible) {
            // 表示点击home键又返回操作,设置可见状态为true
            if (!isHidden() && !getUserVisibleHint() && currentVisibleState) {
                disPatchFragment(true);
            }
        }
    }

    @Override
    public void onPause() {
        LogUtils.showLogCompletion("-----> onPause", "-----> onPause", 1000, "verbose");
        // 表示点击home键,原来可见的Fragment要走该方法，更改Fragment的状态为不可见
        if (!isHidden() && getUserVisibleHint()) {
            disPatchFragment(false);
        }
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        LogUtils.showLogCompletion("-----> onDestroyView", "-----> onDestroyView", 1000, "verbose");
        // 当View被销毁的时候我们需要重新设置 isViewCreated mIsFirstVisible 的状态
        isViewCreated = false;
        mIsFirstVisible = true;
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroyView();
    }
}
