package com.chenyacheng.homecomponent.ui.fragment;

import com.chenyacheng.commoblib.utils.ExceptionHandleUtils;
import com.chenyacheng.homecomponent.model.HomeBean;

/**
 * Home的视图状态模型
 *
 * @author chenyacheng
 * @date 2019/09/02
 */
interface HomeViewState {

    final class HomeResult implements HomeViewState {

        private final HomeBean homeBean;

        HomeResult(HomeBean homeBean) {
            this.homeBean = homeBean;
        }

        HomeBean getResult() {
            return homeBean;
        }
    }

    final class Error implements HomeViewState {

        /**
         * 接收服务端异常数据的处理，或是自定义数据的处理，发送信息通知界面
         */
        private final ExceptionHandleUtils error;

        Error(ExceptionHandleUtils error) {
            this.error = error;
        }

        ExceptionHandleUtils getError() {
            return error;
        }
    }
}
