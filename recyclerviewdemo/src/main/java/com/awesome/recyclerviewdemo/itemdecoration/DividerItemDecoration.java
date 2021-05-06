package com.awesome.recyclerviewdemo.itemdecoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/14 16:50
 * Description: 分割线
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private final Paint mPaint;
    // 动态设置分割线距左边距
    private int mDividerMarginLeft;
    private int mViewMarginTop;
    private int mViewMarginBottom;

    public DividerItemDecoration(Builder builder) {
        mPaint = new Paint();
        mPaint.setColor(builder.mPaintColor);
        mDividerMarginLeft = builder.mDividerMarginLeft;
        mViewMarginTop = builder.mViewMarginTop;
        mViewMarginBottom = builder.mViewMarginBottom;
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (layoutManager instanceof GridLayoutManager) {
            } else {
                int childCount = parent.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childView = parent.getChildAt(i);
                    if (i >= 0) {
                        c.drawRect(childView.getLeft() + mDividerMarginLeft, childView.getBottom() + mViewMarginBottom - 1,
                                childView.getRight(), childView.getBottom() + mViewMarginBottom, mPaint);
                    }
                }
            }
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        // 动态设置边距
        outRect.top = mViewMarginTop;
        outRect.bottom = mViewMarginBottom;
    }

    public static class Builder {
        private int mDividerMarginLeft;
        private int mViewMarginTop;
        private int mViewMarginBottom;
        private int mPaintColor;

        public int getDividerMarginLeft() {
            return mDividerMarginLeft;
        }

        public Builder setDividerMarginLeft(int dividerMarginLeft) {
            mDividerMarginLeft = dividerMarginLeft;
            return this;
        }

        public int getViewMarginTop() {
            return mViewMarginTop;
        }

        public Builder setViewMarginTop(int viewMarginTop) {
            mViewMarginTop = viewMarginTop;
            return this;
        }

        public int getViewMarginBottom() {
            return mViewMarginBottom;
        }

        public Builder setViewMarginBottom(int viewMarginBottom) {
            mViewMarginBottom = viewMarginBottom;
            return this;
        }

        public int getPaintColor() {
            return mPaintColor;
        }

        public Builder setPaintColor(int paintColor) {
            mPaintColor = paintColor;
            return this;
        }

        public DividerItemDecoration build() {
            return new DividerItemDecoration(this);
        }
    }
}
