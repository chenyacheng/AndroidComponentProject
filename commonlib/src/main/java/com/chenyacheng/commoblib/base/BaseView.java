package com.chenyacheng.commoblib.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * view基类
 *
 * @author chenyacheng
 * @date 2019/01/16
 */
public interface BaseView {

    /**
     * 绑定完成Observable发布的事件和当前组件绑定，实现生命周期同步，从而实现当前组件生命周期结束时，自动取消对Observable订阅
     *
     * @param <T> Object对象
     * @return LifecycleTransformer
     */
    <T> LifecycleTransformer<T> bindLifecycle();
}
