package com.chenyacheng.mecomponent.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chenyacheng.commoblib.base.BaseLazyFragment;
import com.chenyacheng.commoblib.custom.snack.SnackBarBuilder;
import com.chenyacheng.commoblib.utils.ExceptionHandleUtils;
import com.chenyacheng.mecomponent.R;
import com.chenyacheng.mecomponent.model.MeBean;

/**
 * fragment我的
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class MeFragment extends BaseLazyFragment<MeContract.View, MeContract.AbstractPresenter> implements MeContract.View {

    private TextView meTv;
    private TextView meTvContent;

    @Override
    protected int getLayoutId() {
        return R.layout.me_fragment_me_main;
    }

    @Override
    protected MeContract.AbstractPresenter createPresenter() {
        return new MePresenter(mContext);
    }

    @Override
    protected MeContract.View createView() {
        return this;
    }

    @Override
    protected void init(View rootView) {
        meTv = rootView.findViewById(R.id.me_tv);
        meTvContent = rootView.findViewById(R.id.me_tv_content);
        Button meBtn = rootView.findViewById(R.id.me_btn);
        meBtn.setOnClickListener(v -> getPresenter().me());
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void render(MeViewState viewState) {
        if (viewState instanceof MeViewState.Error) {
            renderError(((MeViewState.Error) viewState).getError());
        } else if (viewState instanceof MeViewState.MeResult) {
            renderResult(((MeViewState.MeResult) viewState).getResult());
        }
    }

    private void renderError(ExceptionHandleUtils error) {
        SnackBarBuilder.getInstance().builderShort(mContext, error.message);
    }

    private void renderResult(MeBean meBean) {
        meTv.setText(meBean.getTitle());
        meTvContent.setText(meBean.getContent());
    }
}
