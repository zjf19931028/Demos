package com.awesome.recyclerviewdemo.itemdecoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awesome.sdk.util.ShowLogUtil;


/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/6 15:25
 * Description:
 */
public abstract class StickyItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;
    private Rect mTextBounds;
    private int mSpanCount;
    private int mHeight;

    public StickyItemDecoration() {
        this(1);
    }

    public StickyItemDecoration(int spanCount) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mTextBounds = new Rect();
        mSpanCount = spanCount;
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        String preName = null;
        String curName = null;
        int left = parent.getLeft();
        int right = parent.getRight();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(childView);
            curName = getName(position);
            ShowLogUtil.info("position=" + position + ",i=" + i);
            // 界面可显示位置的前SpanCount数，都要被绘制粘性头部
            if (position < mSpanCount || i < mSpanCount) {
                int bottom = Math.max(childView.getTop(), mHeight);
                int top = bottom - mHeight;
                mPaint.setColor(Color.parseColor("#cccccc"));
                c.drawRect(left, top, right, bottom, mPaint);
                mPaint.setColor(Color.BLUE);
                mPaint.setTextSize(30);
                mPaint.getTextBounds(getName(position), 0, getName(position).length(), mTextBounds);
                c.drawText(getName(position), left, bottom - (float) (mHeight / 2) + ((float) mTextBounds.height() / 2), mPaint);
                continue;
            }
            preName = getName(position - mSpanCount);
            // 当前粘性头部和上一个相同时，不显示这个粘性头部
            if (!TextUtils.equals(preName, curName)) {
                int bottom = Math.max(childView.getTop(), mHeight);
                int top = bottom - mHeight;
                mPaint.setColor(Color.parseColor("#cccccc"));
                c.drawRect(left, top, right, bottom, mPaint);
                mPaint.setColor(Color.BLUE);
                mPaint.setTextSize(30);
                mPaint.getTextBounds(getName(position), 0, getName(position).length(), mTextBounds);
                c.drawText(getName(position), left, bottom - (float) (mHeight / 2) + ((float) mTextBounds.height() / 2), mPaint);
            }
        }
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (position < mSpanCount) {
            outRect.top = mHeight;
            return;
        }
        String preName = null;
        String curName = null;
        curName = getName(position);
        preName = getName(position - mSpanCount);
        if (!TextUtils.equals(preName, curName)) {
            outRect.top = mHeight;
        }
    }

    public abstract String getName(int position);

    public void setHeight(int height) {
        mHeight = height;
    }

}
