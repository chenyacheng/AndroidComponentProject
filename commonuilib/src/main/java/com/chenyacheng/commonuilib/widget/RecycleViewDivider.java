package com.chenyacheng.commonuilib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

/**
 * 自定义RecycleView分割线
 *
 * @author chenyacheng
 * @date 2019/01/31
 */
public class RecycleViewDivider extends RecyclerView.ItemDecoration {

    private final Rect mBounds = new Rect();
    private Drawable mDivider;
    private int mOrientation;
    /**
     * 设置左边间距
     */
    private int leftEdge = 0;
    /**
     * 设置右边间距
     */
    private int rightEdge = 0;

    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    public RecycleViewDivider(Context context, int orientation) {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    public RecycleViewDivider(int orientation) {
        if (orientation != 0 && orientation != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        } else {
            this.mOrientation = orientation;
        }
    }

    public void setLeftEdge(int leftEdge) {
        this.leftEdge = leftEdge;
    }

    public void setRightEdge(int rightEdge) {
        this.rightEdge = rightEdge;
    }

    public void setDrawable(@NonNull Drawable drawable) {
        this.mDivider = drawable;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getLayoutManager() != null && this.mDivider != null) {
            if (this.mOrientation == 1) {
                this.drawVertical(c, parent);
            } else {
                this.drawHorizontal(c, parent);
            }
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView parent) {
        canvas.save();
        final int left;
        final int right;
        if (parent.getClipToPadding()) {
            left = parent.getPaddingLeft();
            right = parent.getWidth() - parent.getPaddingRight();
            canvas.clipRect(left, parent.getPaddingTop(), right, parent.getHeight() - parent.getPaddingBottom());
        } else {
            left = 0;
            right = parent.getWidth();
        }

        final int childCount = parent.getChildCount();
        // 最后一个item不画分割线，所以childCount要减去一
        for (int i = 0; i < childCount - 1; ++i) {
            final View child = parent.getChildAt(i);
            parent.getDecoratedBoundsWithMargins(child, this.mBounds);
            final int bottom = this.mBounds.bottom + Math.round(child.getTranslationY());
            final int top = bottom - this.mDivider.getIntrinsicHeight();
            this.mDivider.setBounds(left + leftEdge, top, right - rightEdge, bottom);
            this.mDivider.draw(canvas);
        }

        canvas.restore();
    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        canvas.save();
        final int top;
        final int bottom;
        if (parent.getClipToPadding()) {
            top = parent.getPaddingTop();
            bottom = parent.getHeight() - parent.getPaddingBottom();
            canvas.clipRect(parent.getPaddingLeft(), top, parent.getWidth() - parent.getPaddingRight(), bottom);
        } else {
            top = 0;
            bottom = parent.getHeight();
        }

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; ++i) {
            View child = parent.getChildAt(i);
            if (null != parent.getLayoutManager()) {
                parent.getLayoutManager().getDecoratedBoundsWithMargins(child, this.mBounds);
            }
            final int right = this.mBounds.right + Math.round(child.getTranslationX());
            final int left = right - this.mDivider.getIntrinsicWidth();
            this.mDivider.setBounds(left, top, right, bottom);
            this.mDivider.draw(canvas);
        }

        canvas.restore();
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (this.mDivider == null) {
            outRect.set(0, 0, 0, 0);
        } else {
            if (this.mOrientation == 1) {
                outRect.set(0, 0, 0, 0);
            } else {
                outRect.set(0, 0, this.mDivider.getIntrinsicWidth(), 0);
            }
        }
    }
}
