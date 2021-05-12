package com.awesome.uidemo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.awesome.sdk.util.ShowLogUtil;
import com.awesome.uidemo.R;
import com.awesome.uidemo.util.SystemUtil;
import com.jaeger.library.StatusBarUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/7 18:24
 * Description: 手势页面
 */
public class GestureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        View view = findViewById(R.id.view);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupWindow window = new PopupWindow();
                View contentView = LayoutInflater.from(GestureActivity.this).inflate(R.layout.dialog_long_press, null);
                // PopupWindow 设置内容布局
                window.setContentView(contentView);
                contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
                // PopupWindow 设置宽高
                window.setWidth(contentView.getMeasuredWidth());
                window.setHeight(contentView.getMeasuredHeight());
                // PopupWindow 获取焦点
                window.setFocusable(true);
                // PopupWindow 点击外部消失
                window.setOutsideTouchable(true);
                // 显示 PopupWindow
                window.showAtLocation(view,
                        Gravity.TOP | Gravity.LEFT,
                        0,
                        0);
                return false;
            }
        });
        GestureDetector gestureDetector = new GestureDetector(this,new GestureDetector.OnGestureListener() {
            // 用户按下屏幕会触发
            @Override
            public boolean onDown(MotionEvent e) {
                ShowLogUtil.info("onDown");
                return false;
            }

            // 按下的时间>150ms 时调用
            @Override
            public void onShowPress(MotionEvent e) {
                ShowLogUtil.info("onShowPress");

            }

            // 短点击抬起是调用
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                ShowLogUtil.info("onSingleTapUp");
                return false;
            }

            // 滑动时调用
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                ShowLogUtil.info("onScroll");
                return false;
            }

            // 长按调用
            @Override
            public void onLongPress(MotionEvent e) {
                // 按下屏幕后一段时间触发
                ShowLogUtil.info("onLongPress");
            }

            // 滑动结束时调用
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                ShowLogUtil.info("onFling");
                return false;
            }
        });


        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
//                gestureDetector.onTouchEvent(event);
//                return false;
                return true;
            }
        });


    }
}