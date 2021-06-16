package com.awesome.demos.test.youhua;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by Mjj on 2018/8/28.
 */

public class HandlerLeak1Activity extends Activity {
    private static NoLeakHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Message message = Message.obtain();
        message.what = 1;
        mHandler.sendMessageDelayed(message,10*60*1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    private static class NoLeakHandler extends Handler{
        private WeakReference<HandlerLeak1Activity> mActivity;

        public NoLeakHandler(HandlerLeak1Activity activity){
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }


}
