package com.chenyacheng.commoblib.adapter;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author chenyacheng
 * @date 2019/01/30
 */
public class ViewHolder {

    private final SparseArray<View> mViews;
    private final View mConvertView;

    private ViewHolder(ViewGroup parent, int layoutId) {
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            return new ViewHolder(parent, layoutId);
        }
        return (ViewHolder) convertView.getTag();
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId 控件id
     * @return T
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    View getConvertView() {
        return mConvertView;
    }
}
