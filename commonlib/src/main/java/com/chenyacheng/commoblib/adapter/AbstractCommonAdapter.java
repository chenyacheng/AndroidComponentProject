package com.chenyacheng.commoblib.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * ListView、GridView等适配器
 *
 * @author chenyacheng
 * @date 2019/01/30
 */
public abstract class AbstractCommonAdapter<T> extends BaseAdapter {

    private final int mItemLayoutId;
    /**
     * 数据源
     */
    private List<T> data;
    private int size;

    public AbstractCommonAdapter(int itemLayoutId, List<T> data) {
        this.data = data;
        this.mItemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        if (size != 0) {
            if (data.size() > size) {
                return size;
            } else {
                return data.size();
            }
        } else {
            return data == null ? 0 : data.size();
        }
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder = ViewHolder.get(convertView, parent, mItemLayoutId);
        convert(viewHolder, getItem(position), position);
        return viewHolder.getConvertView();
    }

    /**
     * 转换
     *
     * @param holder   holder
     * @param item     item
     * @param position position
     */
    public abstract void convert(ViewHolder holder, T item, int position);

    public void setSize(int size) {
        this.size = size;
    }

    public void setListData(List<T> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
