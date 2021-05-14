package com.awesome.uidemo.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.awesome.sdk.util.ShowLogUtil;
import com.awesome.uidemo.R;


/**
 * Created by Alice on 2021/3/21
 */
public class MyLayout extends ViewGroup {
    private ImageView addImg;

    private int rowCount = 0;

    private OnClickListener mOnClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageView addImg = new ImageView(getContext());
            addView(addImg);
        }
    };

    public MyLayout(Context context) {
        super(context);
    }

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        addImg = new ImageView(context);
        addImg.setImageResource(R.mipmap.ic_launcher);
        addView(addImg);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.wawa_red);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        rowCount = widthSize/ bitmap.getWidth();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            ImageView view = (ImageView) getChildAt(i);
            int left = i % rowCount * getWidth() / rowCount;
            int top = i / rowCount * getWidth() / rowCount;
            int right = left + getWidth() / rowCount;
            int bottom = top + getWidth() / rowCount;
            ShowLogUtil.info("left=" + left + ",top=" + top + ",right=" + right + ",bottom=" + bottom);
            view.layout(left, top, right, bottom);
            view.setImageResource(R.mipmap.ic_launcher);
            view.setBackgroundColor(Color.BLACK);
            if (i == (getChildCount() - 1)) {
                view.setOnClickListener(mOnClickListener);
            } else {
                view.setOnClickListener(null);
            }
        }
    }
}
