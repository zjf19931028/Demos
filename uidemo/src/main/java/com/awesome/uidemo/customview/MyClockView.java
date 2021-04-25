package com.awesome.uidemo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.awesome.sdk.util.ShowLogUtil;


/**
 * Created by Alice on 2021/3/21
 * 时钟
 */
public class MyClockView extends View {
    private Paint mPaint;
    private int radius;

    public MyClockView(Context context) {
        super(context);
        initPaint();
    }


    public MyClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(50);
        mPaint.setStrokeWidth(2);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int viewWidth = 0;
        int viewHeight = 0;

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        ShowLogUtil.info("widthSize=" + widthSize);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                ShowLogUtil.info("widthMode AT_MOST");
                viewWidth = widthSize / 2;
                break;
            case MeasureSpec.EXACTLY:
                ShowLogUtil.info("widthMode EXACTLY");
                viewWidth = widthSize;
            case MeasureSpec.UNSPECIFIED:
                ShowLogUtil.info("widthMode UNSPECIFIED");
                break;
            default:
                break;
        }
        ShowLogUtil.info("viewWidth=" + viewWidth);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        ShowLogUtil.info("heightSize=" + heightSize);
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                ShowLogUtil.info("heightMode AT_MOST");
                viewHeight = heightSize / 2;
                break;
            case MeasureSpec.EXACTLY:
                ShowLogUtil.info("heightMode EXACTLY");
                viewHeight = heightSize;
            case MeasureSpec.UNSPECIFIED:
                ShowLogUtil.info("heightMode UNSPECIFIED");
                break;
            default:
                break;
        }
        ShowLogUtil.info("viewHeight=" + viewHeight);

        setMeasuredDimension(viewWidth, viewHeight);
        int minSize = Math.min(viewWidth, viewHeight);
        radius = (int) (14f / 30f * minSize);
        ShowLogUtil.info("radius=" + radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidth = getWidth();
        int viewHeight = getHeight();
        // 移动表到中心
        canvas.translate(viewWidth / 2, viewHeight / 2);
        // 表盘
        canvas.drawCircle(0, 0, radius, mPaint);
        // 圆心
        canvas.drawCircle(0, 0, radius / 40, mPaint);
        canvas.drawLine(0, 0, 0, -2f / 3f * radius, mPaint);

        for (int i = 0; i < 60; i++) {
            if (i % 5 == 0) {
                // 5分钟的刻度
                canvas.drawLine(0, -radius, 0, -9f / 10f * radius, mPaint);
                if (i / 5 == 0) {
                    canvas.drawText("12", -radius / 30, -8f / 10f * radius, mPaint);
                } else {
                    canvas.drawText("" + i / 5, -radius / 30, -8f / 10f * radius, mPaint);
                }
            } else {
                // 每分钟的刻度
                canvas.drawLine(0, -radius, 0, -19f / 20f * radius, mPaint);
            }
            canvas.rotate(6);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        return super.onTouchEvent(event);
    }
}