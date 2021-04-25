package com.awesome.uidemo.eventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/25 14:45
 * Description:
 */
public class MyLinearLayout extends LinearLayout {
    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        ShowLogUtil.info("ViewGroup dispatchTouchEvent");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev);
//        ShowLogUtil.info("ViewGroup dispatchTouchEvent="+dispatchTouchEvent);
        return dispatchTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ShowLogUtil.info("ViewGroup onTouchEvent");
        boolean onTouchEvent = super.onTouchEvent(event);
//        ShowLogUtil.info("ViewGroup onTouchEvent="+onTouchEvent);
        return onTouchEvent;
    }


}
