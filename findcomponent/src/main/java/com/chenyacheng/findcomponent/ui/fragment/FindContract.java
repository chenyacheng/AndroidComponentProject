package com.chenyacheng.findcomponent.ui.fragment;

import com.chenyacheng.commoblib.base.BasePresenter;
import com.chenyacheng.commoblib.base.BaseView;

/**
 * 发现页面契约类
 *
 * @author chenyacheng
 * @date 2019/02/19
 */
public interface FindContract {

    interface View extends BaseView {

        /**
         * find测试
         */
        void findResult();

        /**
         * 接收服务端异常数据的处理，或是自定义数据的处理，发送信息通知界面
         *
         * @param msg String
         */
        void setMsg(String msg);
    }

    abstract class AbstractPresenter extends BasePresenter<View> {

        /**
         * find请求
         */
        abstract void find();
    }
}
