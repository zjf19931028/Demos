package com.awesome.uidemo.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

import com.awesome.sdk.util.ShowLogUtil;
import com.awesome.uidemo.R;


/**
 * Created by Alice on 2021/3/21
 * 笔记本
 */
public class NoteView extends EditText {

    private Paint mPaint;

    public NoteView(Context context) {
        super(context);
//        initPaint();
    }

    public NoteView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
//        TypedArray array = context.obtainStyledAttributes(attrs, new int[]{R.attr.lineColor, R.attr.lineWidth});
//        int color = array.getColor(0, Color.RED);
//        float width = array.getDimension(1, 2);
//        mPaint.setColor(color);
//        mPaint.setStrokeWidth(width);

    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int lineHeight = getLineHeight();
        ShowLogUtil.info("getHeight()="+getHeight());
        ShowLogUtil.info("getLineHeight()="+getLineHeight());
        int count = getHeight() / lineHeight;
        ShowLogUtil.info("count="+count);
        for (int i = 0; i < count; i++) {
            canvas.drawLine(0, (i + 1) * lineHeight, getWidth(), (i + 1) * lineHeight, mPaint);
        }
    }
}