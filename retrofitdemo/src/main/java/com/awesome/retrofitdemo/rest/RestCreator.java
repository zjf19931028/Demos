package com.awesome.retrofitdemo.rest;


import com.awesome.retrofitdemo.encapsulation.intercept.LoggingInterceptor;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/27 17:27
 * Description: 请求构建器
 */
public class RestCreator {
    private static final class ParamsHolder {
        /**
         * tip:参数每次请求需要使用，定义为全局参数对象，减少创建对象的个数。
         */
        /**
         * tip：参数在不使用时，希望被垃圾回收器回收
         */
        private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static final WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

    /**
     * tip 单例的静态内部类1：单例的静态内部类创建一个Retrofit对象
     */
    private static final class RetrofitHolder {
        private static final String BASE_URL = "http://www.imooc.com/";
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .build();
    }

    /**
     * 单例的静态内部类创建一个OkHttpClient对象
     */
    private static final class OkHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();

    }

    /**
     * 单例的静态内部类创建一个Service对象
     */
    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }

    /**
     * tip 单例的静态内部类2：封装性的返回一个Service对象
     */
    public static final RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }


}
