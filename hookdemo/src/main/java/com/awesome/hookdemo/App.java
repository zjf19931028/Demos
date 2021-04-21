package com.awesome.hookdemo;

import android.app.Application;
import android.content.Context;

import java.net.HttpCookie;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/21 14:39
 * Description:
 */
public class App extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
