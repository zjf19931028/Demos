package com.awesome.demos.test.broadcast;

import android.app.Activity;
import android.content.IntentFilter;

/**
 * Created by Mjj on 2018/8/14.
 */

public class MyBroadcastActivity extends Activity {

    public MyBroadcastReceiver mBroadcastReceiver;

    // 选择在Activity生命周期方法中的onResume()中注册
    @Override
    protected void onResume() {
        super.onResume();

        // 1. 实例化BroadcastReceiver子类 &  IntentFilter
        mBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();

        // 2. 设置接收广播的类型
        intentFilter.addAction(CONNECTIVITY_SERVICE);

        // 3. 动态注册：调用Context的registerReceiver（）方法
        registerReceiver(mBroadcastReceiver, intentFilter);
    }


    // 注册广播后，要在相应位置记得销毁广播
    // 即在onPause() 中unregisterReceiver(mBroadcastReceiver)
    // 当此Activity实例化时，会动态将MyBroadcastReceiver注册到系统中
    // 当此Activity销毁时，动态注册的MyBroadcastReceiver将不再接收到相应的广播。
    @Override
    protected void onPause() {
        super.onPause();
        //销毁在onResume()方法中的广播
        unregisterReceiver(mBroadcastReceiver);
    }
}


