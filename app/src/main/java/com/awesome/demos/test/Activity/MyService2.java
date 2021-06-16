package com.awesome.demos.test.Activity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * Created by Mjj on 2018/8/8.
 */

public class MyService2 extends Service {

    public String data = "服务器正在执行";

    public MyService2() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    public class Binder extends android.os.Binder {
        public void setData(String data) {
            MyService2.this.data = data;
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


}
