package com.awesome.uidemo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/22 14:39
 * Description:水滴
 */
public class DrawQuadToView extends View {
    private Paint mPaint;
    private int eventX,eventY;
    private int centerX,centerY;
    private int startX,startY;
    private int endX,endY;

    public DrawQuadToView(Context context) {
        super(context);
        init();
    }

    public DrawQuadToView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        //画3个点
        canvas.drawCircle(startX,startY,8,mPaint);
        canvas.drawCircle(endX,endY,8,mPaint);
        canvas.drawCircle(eventX,eventY,8,mPaint);

        //绘制连线
        mPaint.setStrokeWidth(3);
        canvas.drawLine(startX,centerY,eventX,eventY,mPaint);
        canvas.drawLine(endX,centerY,eventX,eventY,mPaint);

        //画二阶贝塞尔曲线
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(startX,startY);
        path.quadTo(eventX,eventY,endX,endY);
        canvas.drawPath(path,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                eventX = (int) event.getX();
                eventY = (int) event.getY();
                invalidate();
                break;
        }
        return true;
    }
}
