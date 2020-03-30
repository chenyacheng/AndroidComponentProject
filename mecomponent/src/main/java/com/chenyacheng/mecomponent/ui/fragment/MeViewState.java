package com.chenyacheng.mecomponent.ui.fragment;

import com.chenyacheng.commonlib.base.BaseErrorViewState;
import com.chenyacheng.commonlib.utils.ExceptionHandleUtils;
import com.chenyacheng.mecomponent.model.MeBean;

/**
 * me的视图状态模型
 *
 * @author chenyacheng
 * @date 2019/09/04
 */
interface MeViewState {

    final class Error extends BaseErrorViewState implements MeViewState {

        Error(ExceptionHandleUtils error) {
            super(error);
        }
    }

    final class MeResult implements MeViewState {

        private final MeBean meBean;

        MeResult(MeBean meBean) {
            this.meBean = meBean;
        }

        MeBean getResult() {
            return meBean;
        }
    }
}
