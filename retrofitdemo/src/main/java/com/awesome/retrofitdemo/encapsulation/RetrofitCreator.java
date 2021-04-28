package com.awesome.retrofitdemo.encapsulation;

import com.awesome.retrofitdemo.encapsulation.api.APIService;
import com.awesome.retrofitdemo.encapsulation.intercept.LoggingInterceptor;
import com.awesome.retrofitdemo.encapsulation.listener.DisposeDataListener;
import com.awesome.retrofitdemo.encapsulation.response.CommonCallback;
import com.awesome.retrofitdemo.rest.RestService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/27 13:48
 * Description: 设置基本配置，获取API服务
 */
public class RetrofitCreator {

    private static final class RetrofitHolder {
        public static final String ROOT_URL = "http://www.imooc.com/";
        private static final Retrofit RETROFIT_HOLDER = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClientHolder.OKHTTPCLIENT_HOLDER)
                .build();
    }

    private static final class OkHttpClientHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OKHTTPCLIENT_HOLDER = new OkHttpClient.Builder()
                // tip：构建者模式添加拦截器，降低耦合性
                .addInterceptor(new LoggingInterceptor())
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder {
        private static final APIService REST_SERVICE =
                RetrofitHolder.RETROFIT_HOLDER.create(APIService.class);
    }

    public static APIService getService() {
        return RestServiceHolder.REST_SERVICE;
    }

}
