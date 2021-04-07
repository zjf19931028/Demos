package com.awesome.okhttpdemo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/30 14:42
 * Description:
 */
public class OKHttpBaseUse {

    private OkHttpClient mOkHttpClient = new OkHttpClient();

    // 异步GET请求
    void getAsync(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()//默认，可不写
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                response.body().string();
            }
        });
    }

    // 同步GET请求
    void getSync(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = mOkHttpClient.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
//                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // post提交String
    void postString(String url) {
        MediaType mediaType = MediaType.get("application/json;charset=utf-8");
        String string = "I am Jdqm.";
        RequestBody requestBody = RequestBody.create(mediaType, string);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
//                    headers.name(i);
//                    headers.value(i);
                }
            }
        });
    }

    // post提交流
    void postStream(String url) {
        RequestBody requestBody = new RequestBody() {
            @Nullable
            @Override
            public MediaType contentType() {
                return MediaType.parse("application/json;charset=utf-8");
            }

            @Override
            public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
                bufferedSink.writeUtf8("I am Jdqm.");
            }
        };
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
//                    headers.name(i);
//                    headers.value(i);
                }
            }
        });
    }

    // post提交文件
    void postFile(String url) {
        MediaType mediaType = MediaType.get("text/x-markdown;charset=utf-8");
        File file = new File("");
        RequestBody requestBody = RequestBody.create(mediaType, file);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
//                    headers.name(i);
//                    headers.value(i);
                }
            }
        });
    }

    void postForm(String url) {
        RequestBody requestBody = new FormBody.Builder()
                .add("search", "Jurassic")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
//                    headers.name(i);
//                    headers.value(i);
                }
            }
        });
    }
}
