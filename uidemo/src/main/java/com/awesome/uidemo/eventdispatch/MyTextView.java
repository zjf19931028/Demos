package com.awesome.uidemo.eventdispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/25 14:46
 * Description:
 */
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        ShowLogUtil.info("View dispatchTouchEvent");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev);
//        ShowLogUtil.info("View dispatchTouchEvent="+dispatchTouchEvent);
        return dispatchTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ShowLogUtil.info("View onTouchEvent");
        boolean onTouchEvent = super.onTouchEvent(event);
//        ShowLogUtil.info("View onTouchEvent="+onTouchEvent);
        return onTouchEvent;
    }
}
