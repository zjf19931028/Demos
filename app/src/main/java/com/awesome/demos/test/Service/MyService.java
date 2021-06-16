package com.awesome.demos.test.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.annotation.Nullable;

/**
 * Created by Mjj on 2018/8/11.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("--onBind()--");
        return new MyBinder();
    }

    public class MyBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }

    }
}