package com.awesome.okhttpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.awesome.okhttpdemo.app.RequestCenter;
import com.awesome.okhttpdemo.okhttp.CommonOkHttpClient;
import com.awesome.okhttpdemo.okhttp.listener.DisposeDataHandle;
import com.awesome.okhttpdemo.okhttp.listener.DisposeDataListener;
import com.awesome.sdk.util.ShowLogUtil;

/**
 * get类型网址：http://www.wanandroid.com/     https://kyfw.12306.cn/otn/
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new OKHttpHelper().getSync("http://www.wanandroid.com/");
//        new OKHttpHelper().getAsync("http://www.wanandroid.com/");
//        OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggingInterceptor())
//                .build();
//        final Call call = mOkHttpClient.newCall(CommonRequest.createGetRequest("http://www.wanandroid.com/", null));
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Response response = call.execute();
//                    String string = response.body().string();
//                    ShowLogUtil.info(string);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

//                new DisposeDataListener() {
//                    @Override
//                    public void onSuccess(Object responseObj) {
//                        ShowLogUtil.info("onSuccess");
//                        ShowLogUtil.info(responseObj.toString());
//                    }
//
//                    @Override
//                    public void onFailure(Object reasonObj) {
//                        ShowLogUtil.info("onFailure");
//                        ShowLogUtil.info(reasonObj.toString());
//                    }
//                }, null);

        /**
         * OkHttp封装
         * step1-1:调用登录方法。传递真实的参数信息，实现回调方法
         */
        /**
         * OkHttp封装
         * step2-6:调用登录方法。
         */
        RequestCenter.login("Jane", "123", new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                ShowLogUtil.info("onSuccess");
                ShowLogUtil.info(responseObj.toString());
            }

            @Override
            public void onFailure(Object reasonObj) {
                ShowLogUtil.info("onFailure");
                ShowLogUtil.info(reasonObj.toString());
            }
        });
    }
}