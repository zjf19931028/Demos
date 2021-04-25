package com.awesome.uidemo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/19 16:56
 * Description:水滴
 */
public class WaterDropView extends View {
    private Paint mPaint;
    private int mCenterWidthPoint;
    private int mCenterHeightPoint;

    private OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            invalidate();
        }
    };
    private int mTimes;

    public WaterDropView(Context context) {
        super(context);
        init();
    }

    public WaterDropView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#cccccc"));
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = 0;
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMode) {
            case MeasureSpec.AT_MOST:
                width = widthSize / 2;
                break;
            case MeasureSpec.EXACTLY:
                width = widthSize;
                break;
            default:
                break;
        }

        int height = 0;
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
                height = heightSize / 2;
                break;
            case MeasureSpec.EXACTLY:
                height = heightSize;
                break;
            default:
                break;
        }
        mCenterWidthPoint = width / 2;
        mCenterHeightPoint = height / 2;
        mTimes = Math.min(widthSize, heightSize) / 4;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    int n = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#cccccc"));

        canvas.drawColor(Color.WHITE);
        canvas.translate(mCenterWidthPoint, mCenterHeightPoint);

        // 水滴瓶框架
        canvas.drawLine(0, -2 * mTimes, -1 * mTimes, -1 * mTimes, mPaint);
        canvas.drawLine(0, -2 * mTimes, 1 * mTimes, -1 * mTimes, mPaint);
        RectF mRectFCircle = new RectF(-1.41f * mTimes, -1.41f * mTimes, 1.41f * mTimes, 1.41f * mTimes);
        canvas.drawArc(mRectFCircle, 315, 270, false, mPaint);

        // 瓶子中的水
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#FF4C7EFF"));

        n += 50;
        if (n == (((int) (2 * 1.41f * mTimes)) + 2 * 50)) {
            n = 0;
        } else if (n == (((int) (2 * 1.41f * mTimes)) + 50)) {
            Path path = new Path();
            path.moveTo(0, -2 * mTimes + 50);
            path.lineTo(-1 * mTimes, -1 * mTimes);
            path.lineTo(1 * mTimes, -1 * mTimes);
            path.close();
            canvas.drawPath(path, mPaint);
        } else if (n >= 2 * 1.41f * mTimes) {
            n = (int) (2 * 1.41f * mTimes);
        }
        Path path1 = new Path();
        path1.addCircle(0, 0, 1.414f * mTimes, Path.Direction.CCW);
        Path path2 = new Path();
        path2.addRect(-1.41f * mTimes, 1.41f * mTimes - n, 1.41f * mTimes, 1.41f * mTimes, Path.Direction.CCW);
        path1.op(path2, Path.Op.INTERSECT);

        canvas.drawPath(path1, mPaint);

        postInvalidateDelayed(500);

        setOnClickListener(mOnClickListener);
    }
}
