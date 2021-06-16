package com.awesome.demos.test.Activity;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;

/**
 * Created by Mjj on 2018/8/8.
 */

public class MyService1 extends Service {

    public String data = "服务器正在执行";
    public MyService1() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        data = intent.getStringExtra("data");
        return super.onStartCommand(intent, flags, startId);
    }

}
