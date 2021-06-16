package com.awesome.demos.test.Activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Mjj on 2018/8/8.
 */

public class MyService3 extends Service {
    private static final String TAG = "ActivityTest";
    private Callback callback;
    public String data = "服务器正在执行";

    public MyService3() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "服务器已绑定");
        return new Binder();
    }

    public class Binder extends android.os.Binder {
        public void setData(String data) {
            MyService3.this.data = data;
        }

        public MyService3 getMyService() {
            return MyService3.this;
        }
    }


    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        data = intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public Callback getCallback() {
        return callback;
    }

    public interface Callback {
        void onDataChange(String data);
    }


}
