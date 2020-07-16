package com.chenyacheng.findcomponent.ui.fragment;

import com.chenyacheng.commonuilib.BaseErrorViewState;
import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;
import com.chenyacheng.findcomponent.model.FindBean;

/**
 * Find的视图状态模型
 *
 * @author chenyacheng
 * @date 2019/09/04
 */
interface FindViewState {

    final class Error extends BaseErrorViewState implements FindViewState {

        Error(ExceptionHandleUtils error) {
            super(error);
        }
    }

    final class FindResult implements FindViewState {

        private final FindBean findBean;

        FindResult(FindBean findBean) {
            this.findBean = findBean;
        }

        FindBean getResult() {
            return findBean;
        }
    }
}
