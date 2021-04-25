package com.awesome.okhttpdemo;

import com.awesome.sdk.util.ShowLogUtil;

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
 * Description: get的同步和异步请求，post的字符串、流、文件、表单请求
 * 同步为execute，异步为enqueue
 */
public class OKHttpHelper {
    private OkHttpClient mOkHttpClient = new OkHttpClient();
    // 添加拦截器
//    private OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
//            .addInterceptor(new LoggingInterceptor())
//            .build();

    // 同步GET请求
    void getSync(String url) {
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "OkHttp Example")//添加头部，可不写
                .get()//默认，可不写
                .build();
        final Call call = mOkHttpClient.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    String string = response.body().string();
                    ShowLogUtil.info(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    // 异步GET请求
    void getAsync(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                // 现在还在子线程中
                String string = response.body().string();
                ShowLogUtil.info(string);
            }
        });
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
        mOkHttpClient.newCall(request)
                .enqueue(new Callback() {
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
        mOkHttpClient.newCall(request)
                .enqueue(new Callback() {
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
        mOkHttpClient.newCall(request)
                .enqueue(new Callback() {
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

    // post提交表单
    void postForm(String url) {
        RequestBody requestBody = new FormBody.Builder()
                .add("search", "Jurassic")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request)
                .enqueue(new Callback() {
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
