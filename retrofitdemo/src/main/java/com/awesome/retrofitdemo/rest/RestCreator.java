package com.awesome.retrofitdemo.rest;


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
    /**
     * 封装性的返回一个Service对象
     * @return
     */
    public static final RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    /**
     * 单例的静态内部类创建一个Retrofit对象
     */
    private static final class RetrofitHolder {
        private static final String BASE_URL = "";
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

}
