package com.chenyacheng.mecomponent.ui.fragment;

import com.chenyacheng.commoblib.base.BasePresenter;
import com.chenyacheng.commoblib.base.BaseView;

/**
 * 首页页面契约类
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public interface MeContract {

    interface View extends BaseView {

        /**
         * me测试
         */
        void meResult();

        /**
         * 接收服务端异常数据的处理，或是自定义数据的处理，发送信息通知界面
         *
         * @param msg String
         */
        void setMsg(String msg);
    }

    abstract class AbstractPresenter extends BasePresenter<View> {

        /**
         * me请求
         */
        abstract void me();
    }
}
