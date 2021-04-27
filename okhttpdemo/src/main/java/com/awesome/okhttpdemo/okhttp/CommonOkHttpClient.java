package com.awesome.okhttpdemo.okhttp;

import com.awesome.okhttpdemo.okhttp.https.HttpsUtils;
import com.awesome.okhttpdemo.okhttp.listener.DisposeDataHandle;
import com.awesome.okhttpdemo.okhttp.listener.DisposeDataListener;
import com.awesome.okhttpdemo.okhttp.request.CommonRequest;
import com.awesome.okhttpdemo.okhttp.request.RequestParams;
import com.awesome.okhttpdemo.okhttp.response.CommonCallback;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/25 18:09
 * Description:
 */
/**
 * OkHttpClient封装
 * step1-4:设置OkHttpClient，调用一个get/post网络请求的过程。传递"url"、"参数类"，创建Request类；传递"回调对象"、"解析实体类"，创建回调的实现类。
 */
/**
 * OkHttpClient封装
 * step2-1:设置OkHttpClient，调用一个get/post网络请求的过程。去封装一个Request类，需要url、参数：封装一个参数类；去封装一个回调的实现类。
 */
public class CommonOkHttpClient {
    private static final int TIME_OUT = 30;
    private static OkHttpClient mOkHttpClient;

    static {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        // 为所有请求添加头部，看个人需求
        okHttpClientBuilder.addInterceptor(new Interceptor() {
            @NotNull
            @Override
            public Response intercept(@NotNull Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .header("User-Agent", "OkHttp Example")//添加头部，可不写
                        .build();
                return chain.proceed(request);
            }
        });
        // 设置超时
        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        // 允许请求重定向或转发
        okHttpClientBuilder.followRedirects(true);
        // https支持
        okHttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        // 支持ssl socket
        okHttpClientBuilder.sslSocketFactory(HttpsUtils.initSSLSocketFactory(), HttpsUtils.initTrustManager());
        mOkHttpClient = okHttpClientBuilder.build();
    }

    public static OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

//    /**
//     * 发送具体的http/https请求
//     *
//     * @param url               网络请求的具体url
//     * @param params            网络请求的参数
//     * @param disposeDataHandle 网络请求的返回信息处理
//     * @return
//     */
//    public static Call get(String url, RequestParams params, DisposeDataHandle disposeDataHandle) {
//        Request request = CommonRequest.createGetRequest(url, params);
//        Call call = mOkHttpClient.newCall(request);
//        call.enqueue(new CommonCallback(disposeDataHandle));
//        return call;
//    }

    public static void get(String url, RequestParams params, DisposeDataListener listener, Class<?> aClass) {
        Request request = CommonRequest.createGetRequest(url, params);
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonCallback(listener, aClass));
    }

    public static Call post(String url, RequestParams params, DisposeDataHandle disposeDataHandle) {
        Request request = CommonRequest.createPostRequest(url, params);
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new CommonCallback(disposeDataHandle));
        return call;
    }
}
