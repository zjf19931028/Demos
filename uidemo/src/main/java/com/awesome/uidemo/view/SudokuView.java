package com.awesome.uidemo.view;

import android.content.Context;
import android.graphics.Paint;
import android.widget.LinearLayout;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/23 18:03
 * Description:
 */
public class SudokuView extends LinearLayout {
    private Paint mPaint;
    public SudokuView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        mPaint =new Paint();
    }
}
