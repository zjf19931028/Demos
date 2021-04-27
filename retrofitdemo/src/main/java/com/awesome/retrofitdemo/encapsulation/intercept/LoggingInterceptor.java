package com.awesome.retrofitdemo.encapsulation.intercept;

import android.util.Log;

import com.awesome.sdk.util.ShowLogUtil;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/30 16:00
 * Description:打印日志拦截器
 */
public class LoggingInterceptor implements Interceptor {

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.nanoTime();
//        ShowLogUtil.info("request.url()=" + request.url());
//        ShowLogUtil.info("chain.connection()=" + chain.connection());
//        ShowLogUtil.info("request.headers()=" + request.headers());
        Response response = chain.proceed(request);
        long endTime = System.nanoTime();
        Log.i("Retrofit","response.request().url=" + response.request().url());
        Log.i("Retrofit","endTime-startTime=" + (endTime - startTime));
        Log.i("Retrofit","response.headers=" + response.headers());
        return response;
    }
}
