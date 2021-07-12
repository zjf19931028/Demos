package com.awesome.uidemo.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import androidx.annotation.Nullable;

import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: zhangjingfang
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/7/10 11:03 下午
 * Description:类描述
 */
public class CustomScrollView extends androidx.appcompat.widget.AppCompatTextView {

    private Scroller mScroller;

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public CustomScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        ShowLogUtil.info("mScroller.computeScrollOffset()=" + mScroller.computeScrollOffset());
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
            ShowLogUtil.info("mScroller.getCurrX() =" + mScroller.getCurrX() + "," + mScroller.getCurrY());
        }
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        mScroller.startScroll(scrollX, 0, delta, 0, 2000);
        invalidate();
    }

    int lastX = 0;
    int lastY = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                invalidate();
                ShowLogUtil.info("offsetX=" + offsetX + "," + offsetY);
                // 方法一
//                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
//                // 方法二
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
//                // 方法三
//                ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
//                lp.leftMargin = getLeft() + offsetX;
//                lp.topMargin = getTop() + offsetY;
//                setLayoutParams(lp);
//                // 方法四
//                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
        }
        return true;
    }
}