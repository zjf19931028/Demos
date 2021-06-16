package com.awesome.demos.test.youhua;

import android.content.Context;

/**
 * Created by Mjj on 2018/8/28.
 */

public class SingleInstance {
    private Context mContext;
    private static SingleInstance instance;

    private SingleInstance(Context context) {
        this.mContext = context;
    }

    public static SingleInstance getInstance(Context context) {
        if (instance == null) {
            instance = new SingleInstance(context);
        }
        return instance;
    }
}
