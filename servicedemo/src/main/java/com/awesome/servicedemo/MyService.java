package com.awesome.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/25 09:51
 * Description:
 */
public class MyService extends Service {
    private boolean flag;
    private int mProgress;

    public class MyBinder extends Binder {
        public int getProgress() {
            return mProgress;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        flag = true;
//        ShowLogUtil.info("onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        ShowLogUtil.info("onStartCommand");
//        ToastUtils.showToast(this, "2342134");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    ShowLogUtil.info("i=" + i);
                    if (!flag) break;
                }

            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
//        ShowLogUtil.info("onBind");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
//        ShowLogUtil.info("onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        flag = false;
//        ShowLogUtil.info("onDestroy");
    }
}
