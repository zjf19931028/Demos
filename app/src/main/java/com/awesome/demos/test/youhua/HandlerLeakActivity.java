package com.awesome.demos.test.youhua;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by Mjj on 2018/8/28.
 */

public class HandlerLeakActivity extends Activity {
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Message message = Message.obtain();
        message.what = 1;
        mHandler.sendMessageDelayed(message,10*60*1000);
    }

}
