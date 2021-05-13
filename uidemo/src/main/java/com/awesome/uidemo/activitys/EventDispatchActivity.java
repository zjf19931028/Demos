package com.awesome.uidemo.activitys;

import android.os.Bundle;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.awesome.sdk.util.ShowLogUtil;
import com.awesome.uidemo.R;

/**
 * 事件分发机制
 * 重要方法：dispatchTouchEvent和onTouchEvent
 * 重要元素：Activity、ViewGroup、View
 * 传递顺序：蛇形走位
 * 停止传递原因：有方法返回true，不再向下传递
 * onInterceptTouchEvent：仅ViewGroup有onInterceptTouchEvent，返回true时，忽略View的处理
 */
public class EventDispatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_dispatch);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        ShowLogUtil.info("Activity dispatchTouchEvent");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(ev);
        ShowLogUtil.info("Activity dispatchTouchEvent="+dispatchTouchEvent);
        return dispatchTouchEvent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ShowLogUtil.info("Activity onTouchEvent");
        boolean onTouchEvent = super.onTouchEvent(event);
        ShowLogUtil.info("Activity onTouchEvent="+onTouchEvent);
        return onTouchEvent;
    }
}