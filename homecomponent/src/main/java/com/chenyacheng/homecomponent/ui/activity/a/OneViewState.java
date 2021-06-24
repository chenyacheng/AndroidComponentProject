package com.chenyacheng.homecomponent.ui.activity.a;

import com.chenyacheng.commonuilib.base.BaseErrorViewState;
import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;
import com.chenyacheng.homecomponent.model.TestBean;

/**
 * @author chenyacheng
 * @date 2019/09/09
 */
public interface OneViewState {

    final class Error extends BaseErrorViewState implements OneViewState {

        Error(ExceptionHandleUtils error) {
            super(error);
        }
    }

    final class TestResult implements OneViewState {

        TestResult(boolean receive){
            TestBean.setReceive(receive);
        }
    }
}
