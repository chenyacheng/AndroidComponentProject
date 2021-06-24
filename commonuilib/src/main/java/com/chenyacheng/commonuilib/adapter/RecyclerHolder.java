package com.chenyacheng.commonuilib.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * @author chenyacheng
 * @date 2019/01/30
 */
public class RecyclerHolder extends RecyclerView.ViewHolder {

    private final SparseArray<View> views;

    RecyclerHolder(View itemView) {
        super(itemView);
        this.views = new SparseArray<>();
    }

    /**
     * 通过view的id获取对应的控件，如果没有则加入views中
     *
     * @param viewId 控件的id
     * @return 返回一个控件
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
