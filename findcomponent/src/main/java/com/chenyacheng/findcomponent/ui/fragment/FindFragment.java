package com.chenyacheng.findcomponent.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chenyacheng.commoblib.base.BaseLazyFragment;
import com.chenyacheng.commoblib.custom.snack.SnackBarBuilder;
import com.chenyacheng.commoblib.utils.ExceptionHandleUtils;
import com.chenyacheng.findcomponent.R;
import com.chenyacheng.findcomponent.model.FindBean;

/**
 * fragment发现
 *
 * @author chenyacheng
 * @date 2019/02/16
 */
public class FindFragment extends BaseLazyFragment<FindContract.View, FindContract.AbstractPresenter> implements FindContract.View {

    private TextView findTv;
    private TextView findTvContent;

    @Override
    protected int getLayoutId() {
        return R.layout.find_fragment_find_main;
    }

    @Override
    protected FindContract.AbstractPresenter createPresenter() {
        return new FindPresenter(mContext);
    }

    @Override
    protected FindContract.View createView() {
        return this;
    }

    @Override
    protected void init(View rootView) {
        findTv = rootView.findViewById(R.id.find_tv);
        findTvContent = rootView.findViewById(R.id.find_tv_content);
        Button findBtn = rootView.findViewById(R.id.find_btn);
        findBtn.setOnClickListener(v -> getPresenter().find());
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void render(FindViewState viewState) {
        if (viewState instanceof FindViewState.Error) {
            renderError(((FindViewState.Error) viewState).getError());
        } else if (viewState instanceof FindViewState.FindResult) {
            renderResult(((FindViewState.FindResult) viewState).getResult());
        }
    }

    private void renderError(ExceptionHandleUtils error) {
        SnackBarBuilder.getInstance().builderShort(mContext, error.message);
    }

    private void renderResult(FindBean result) {
        findTv.setText(result.getTitle());
        findTvContent.setText(result.getContent());
    }
}
