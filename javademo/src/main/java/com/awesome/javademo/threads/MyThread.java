package com.awesome.javademo.threads;

import android.os.SystemClock;

import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: zhangjingfang
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/6/22 11:10 下午
 * Description:类描述
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        int i = 0;
        SystemClock.sleep(3000);
        ShowLogUtil.info(getName() + ",Complete!");
        if (mOnListener != null)
            mOnListener.onComplete();

    }

    private OnListener mOnListener;

    public void setListener(OnListener onListener) {
        mOnListener = onListener;
    }

    public interface OnListener {
        void onComplete();
    }
}