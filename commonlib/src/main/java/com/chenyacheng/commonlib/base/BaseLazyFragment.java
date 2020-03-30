package com.chenyacheng.commonlib.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.chenyacheng.commonlib.utils.LogUtils;

/**
 * 父类->基类->动态指定类型->泛型设计（通过泛型指定动态类型->由子类指定，父类只需要规定范围即可）
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public abstract class BaseLazyFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment {

    protected Activity mContext;
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
     * 返回资源的布局
     *
     * @return 布局
     */
    protected abstract int getLayoutId();

    /**
     * 创建Presenter
     *
     * @return Presenter
     */
    protected abstract P createPresenter();

    /**
     * 创建View
     *
     * @return View
     */
    protected abstract V createView();

    /**
     * 初始化
     *
     * @param rootView rootView
     */
    protected abstract void init(View rootView);

    @Override
    public void onResume() {
        super.onResume();
        if (isViewCreated) {
            // 可见又是第一次
            if (mIsFirstVisible) {
                lazyLoad();
                // 改变首次可见的状态
                mIsFirstVisible = false;
                LogUtils.showLogCompletion("onFragmentFirst", "首次可见", 1000, "verbose");
            }
        }
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

    /**
     * 加载要显示的数据
     */
    protected abstract void lazyLoad();

    protected P getPresenter() {
        return presenter;
    }
}
