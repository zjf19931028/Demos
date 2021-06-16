package com.awesome.servicedemo.aidl;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

/**
 * Created by Alice on 2021/6/7
 */
public class MyIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}