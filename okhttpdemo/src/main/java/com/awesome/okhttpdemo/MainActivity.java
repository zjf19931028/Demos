package com.awesome.okhttpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.awesome.okhttpdemo.okhttp.request.CommonRequest;
import com.awesome.sdk.util.ShowLogUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        new OKHttpHelper().getSync("http://www.wanandroid.com/");
//        new OKHttpHelper().getAsync("http://www.wanandroid.com/");
        new OKHttpHelper().getAsync("https://kyfw.12306.cn/otn/");
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
    }
}