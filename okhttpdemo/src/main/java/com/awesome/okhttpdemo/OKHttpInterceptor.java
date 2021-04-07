package com.awesome.okhttpdemo;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/30 15:47
 * Description:
 */
public class OKHttpInterceptor {
    private OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new com.future.message.okhttp.baseuse.LoggingInterceptor())
            .build();

    void get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "OkHttp Example")
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody body = response.body();
                if (body != null) {
                    body.close();
                }

            }
        });

    }
}
