package com.awesome.retrofitdemo.encapsulation;

import com.awesome.retrofitdemo.encapsulation.api.APIService;
import com.awesome.retrofitdemo.encapsulation.listener.DisposeDataListener;
import com.awesome.retrofitdemo.encapsulation.response.CommonCallback;

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
    public static final String ROOT_URL="http://www.imooc.com/";
    public static Retrofit mRetrofit;

    static {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(ROOT_URL);
        builder.addConverterFactory(GsonConverterFactory.create());
        mRetrofit = builder.build();
    }

    public static APIService getService() {
        return mRetrofit.create(APIService.class);
    }

    public static Retrofit getRetrofit() {
        return mRetrofit;
    }
}
