package com.chenyacheng.homecomponent.ui.fragment;

import com.chenyacheng.commonuilib.BaseErrorViewState;
import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;
import com.chenyacheng.homecomponent.model.HomeBean;

/**
 * Home的视图状态模型
 *
 * @author chenyacheng
 * @date 2019/09/02
 */
interface HomeViewState {

    final class Error extends BaseErrorViewState implements HomeViewState {

        Error(ExceptionHandleUtils error) {
            super(error);
        }
    }

    final class HomeResult implements HomeViewState {

        private final HomeBean homeBean;

        HomeResult(HomeBean homeBean) {
            this.homeBean = homeBean;
        }

        HomeBean getResult() {
            return homeBean;
        }
    }

    final class TestResult implements HomeViewState {

        private final String string;

        TestResult(String string) {
            this.string = string;
        }

        String getTestResult() {
            return string;
        }
    }
}
