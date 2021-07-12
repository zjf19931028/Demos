package com.awesome.animationdemo.widget;

import android.view.View;

/**
 * Author: zhangjingfang
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/7/12 8:49 下午
 * Description:类描述
 */
public class MyView {
    private View mTarget;

    public MyView(View target) {
        mTarget = target;
    }

    public int getWidth(){
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width){
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }
}