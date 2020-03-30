package com.chenyacheng.commonlib.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.chenyacheng.commonlib.R;
import com.chenyacheng.commonlib.adapter.RecyclerHolder;

import java.util.List;

/**
 * RecyclerAdapter适配器，支持上拉加载
 *
 * @author chenyacheng
 * @date 2019/01/30
 */
public abstract class AbstractCommonRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerHolder> {

    /**
     * 正在加载
     */
    public final int LOADING = 1;
    /**
     * 加载完成
     */
    public final int LOADING_COMPLETE = 2;
    /**
     * 加载到底
     */
    public final int LOADING_END = 3;
    /**
     * 数据源
     */
    private List<T> list;
    /**
     * 布局id
     */
    private int itemLayoutId;
    /**
     * 点击事件监听器
     */
    private OnItemClickListener listener;
    /**
     * 长按监听器
     */
    private OnItemLongClickListener longClickListener;
    private RecyclerView recyclerView;
    private int size;
    private boolean mIsLoadMore = false;
    private int mFootLayoutId;
    private int normalType = 1;
    private int footType = 2;
    /**
     * 当前加载状态，默认为加载完成
     */
    private int loadState = 2;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (listener != null && v != null && recyclerView != null) {
                listener.onItemClick(recyclerView, v, (Integer) v.getTag());
            }
        }
    };
    private View.OnLongClickListener onLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (longClickListener != null && v != null && recyclerView != null) {
                longClickListener.onItemLongClick(recyclerView, v, (Integer) v.getTag());
                return true;
            }
            return false;
        }
    };

    public AbstractCommonRecyclerAdapter(int itemLayoutId, List<T> list) {
        this.list = list;
        this.itemLayoutId = itemLayoutId;
    }

    public AbstractCommonRecyclerAdapter(int itemLayoutId, int footLayoutId, List<T> list) {
        this.list = list;
        this.itemLayoutId = itemLayoutId;
        mFootLayoutId = footLayoutId;
        mIsLoadMore = true;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == normalType) {
            return new RecyclerHolder(LayoutInflater.from(parent.getContext()).inflate(itemLayoutId, parent, false));
        } else {
            return new RecyclerHolder(LayoutInflater.from(parent.getContext()).inflate(mFootLayoutId, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(onClickListener);
        holder.itemView.setOnLongClickListener(onLongClickListener);
        if (normalType == holder.getItemViewType()) {
            convert(holder, list.get(position), position);
        } else {
            LinearLayout llFooter = holder.getView(R.id.ll_footer);
            llFooter.setEnabled(false);
            ProgressBar pbLoading = holder.getView(R.id.pb_loading);
            TextView tvLoading = holder.getView(R.id.tv_loading);
            LinearLayout llEnd = holder.getView(R.id.ll_end);
            switch (loadState) {
                // 正在加载
                case LOADING:
                    pbLoading.setVisibility(View.VISIBLE);
                    tvLoading.setVisibility(View.VISIBLE);
                    llEnd.setVisibility(View.GONE);
                    break;
                // 加载完成
                case LOADING_COMPLETE:
                    pbLoading.setVisibility(View.INVISIBLE);
                    tvLoading.setVisibility(View.INVISIBLE);
                    llEnd.setVisibility(View.GONE);
                    break;
                // 加载到底
                case LOADING_END:
                    pbLoading.setVisibility(View.GONE);
                    tvLoading.setVisibility(View.GONE);
                    llEnd.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mIsLoadMore) {
            if (position == getItemCount() - 1) {
                return footType;
            } else {
                return normalType;
            }
        } else {
            return normalType;
        }
    }

    @Override
    public int getItemCount() {
        if (mIsLoadMore) {
            return list.size() + 1;
        } else {
            if (size != 0) {
                if (list.size() > size) {
                    return size;
                } else {
                    return list.size();
                }
            } else {
                return list == null ? 0 : list.size();
            }
        }
    }

    /**
     * 在RecyclerView提供数据的时候调用
     *
     * @param recyclerView recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerView = null;
    }

    /**
     * 填充RecyclerView适配器的方法，子类需要重写
     *
     * @param holder   RecyclerHolder
     * @param item     子项
     * @param position 位置
     */
    public abstract void convert(RecyclerHolder holder, T item, int position);

    public void setListData(List<T> data) {
        this.list = data;
        notifyDataSetChanged();
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addDataList(List<T> addData) {
        if (null != list) {
            list.addAll(addData);
        }
        notifyDataSetChanged();
    }

    /**
     * 设置上拉加载状态
     *
     * @param loadState 0.正在加载 1.加载完成 2.加载到底
     */
    public void setLoadState(int loadState) {
        this.loadState = loadState;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }

    /**
     * 定义一个点击事件接口回调
     */
    public interface OnItemClickListener {
        /**
         * 点击
         *
         * @param parent   parent
         * @param view     view
         * @param position position
         */
        void onItemClick(RecyclerView parent, View view, int position);
    }

    public interface OnItemLongClickListener {
        /**
         * 长按
         *
         * @param parent   parent
         * @param view     view
         * @param position position
         */
        void onItemLongClick(RecyclerView parent, View view, int position);
    }
}
