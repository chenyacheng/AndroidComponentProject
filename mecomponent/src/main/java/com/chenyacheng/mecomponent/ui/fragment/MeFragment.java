package com.chenyacheng.mecomponent.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chenyacheng.commoblib.base.BaseLazyFragment;
import com.chenyacheng.commoblib.custom.snack.SnackBarBuilder;
import com.chenyacheng.mecomponent.R;

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
    public int getLayoutId() {
        return R.layout.me_fragment_me_main;
    }

    @Override
    public MeContract.AbstractPresenter createPresenter() {
        return new MePresenter(mContext);
    }

    @Override
    public MeContract.View createView() {
        return this;
    }

    @Override
    public void init(View rootView) {
        meTv = rootView.findViewById(R.id.me_tv);
        meTvContent = rootView.findViewById(R.id.me_tv_content);
        Button meBtn = rootView.findViewById(R.id.me_btn);
        meBtn.setOnClickListener(v -> getPresenter().me());
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void meResult(MeModel meModel) {
        meTv.setText(meModel.getTitle());
        meTvContent.setText(meModel.getContent());
    }

    @Override
    public void setMsg(String msg) {
        SnackBarBuilder.getInstance().builderShort(mContext, msg);
    }
}
