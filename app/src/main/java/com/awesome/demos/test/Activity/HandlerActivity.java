package com.awesome.demos.test.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.awesome.demos.R;


/**
 * Created by Mjj on 2018/8/1.
 */

public class HandlerActivity extends Activity {
    public static final int MSG_FINISH = 0X001;
    //创建一个Handler的匿名内部类
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_FINISH:
                    Log.e("handler所在的线程id是-->", Thread.currentThread().getName());
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //启动耗时操作
        consumeTimeThread(findViewById(R.id.tv));
//        handler.post()
    }

    //启动一个耗时线程
    public void consumeTimeThread(View view) {
        new Thread() {
            public void run() {
                try {
                    Log.e("耗时子线程的Name是--->", Thread.currentThread().getName());
                    //在子线程运行
                    Thread.sleep(2000);
                    //完成后，发送下载完成消息
                    handler.sendEmptyMessage(MSG_FINISH);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
