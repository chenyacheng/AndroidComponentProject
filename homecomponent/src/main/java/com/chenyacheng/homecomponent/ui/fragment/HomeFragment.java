package com.chenyacheng.homecomponent.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chenyacheng.commonlib.base.BaseLazyFragment;
import com.chenyacheng.commonuilib.constant.RouterConstant;
import com.chenyacheng.commonuilib.utils.ExceptionHandleUtils;
import com.chenyacheng.homecomponent.R;
import com.chenyacheng.homecomponent.model.HomeBean;
import com.chenyacheng.snackbar.SnackBarBuilder;

/**
 * fragment首页
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class HomeFragment extends BaseLazyFragment<HomeContract.View, HomeContract.AbstractPresenter> implements HomeContract.View {

    private TextView homeTv;
    private TextView homeTvContent;
    private TextView homeTextView;

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment_home_main;
    }

    @Override
    protected HomeContract.AbstractPresenter createPresenter() {
        return new HomePresenter(mContext);
    }

    @Override
    protected HomeContract.View createView() {
        return this;
    }

    @Override
    protected void init(View rootView) {
        homeTv = rootView.findViewById(R.id.home_tv);
        homeTvContent = rootView.findViewById(R.id.home_tv_content);
        Button homeBtn = rootView.findViewById(R.id.home_btn);
        homeBtn.setOnClickListener(v -> getPresenter().home());

        EditText homeEditText = rootView.findViewById(R.id.home_edit_text);
        homeTextView = rootView.findViewById(R.id.home_text_view);
        Button homeButton = rootView.findViewById(R.id.home_button);
        homeButton.setOnClickListener(v -> {
            String str = homeEditText.getText().toString();
            if (!str.isEmpty()) {
                getPresenter().test(str);
            } else {
                SnackBarBuilder.getInstance().builderShort(homeButton, "请输入内容");
            }
        });

        Button homeBtnOne = rootView.findViewById(R.id.home_btn_one);
        homeBtnOne.setOnClickListener(v -> ARouter.getInstance().build(RouterConstant.PATH_HOME_ONE_ACTIVITY).navigation());
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void render(HomeViewState viewState) {
        if (viewState instanceof HomeViewState.Error) {
            renderError(((HomeViewState.Error) viewState).getError());
        } else if (viewState instanceof HomeViewState.HomeResult) {
            renderResult(((HomeViewState.HomeResult) viewState).getResult());
        } else if (viewState instanceof HomeViewState.TestResult) {
            renderTest(((HomeViewState.TestResult) viewState).getTestResult());
        }
    }

    private void renderError(ExceptionHandleUtils error) {
        SnackBarBuilder.getInstance().builderShort(mContext, error.message);
    }

    private void renderResult(HomeBean homeBean) {
        homeTv.setText(homeBean.getName());
        homeTvContent.setText(homeBean.getSex());
    }

    private void renderTest(String testResult) {
        homeTextView.setText(testResult);
    }
}
