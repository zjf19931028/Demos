package com.awesome.retrofitdemo.encapsulation;

import com.awesome.retrofitdemo.encapsulation.listener.DisposeDataListener;
import com.awesome.retrofitdemo.encapsulation.response.CommonCallback;

import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.http.QueryMap;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/27 16:05
 * Description: 请求类，请求url，请求参数
 */
public class RetrofitRequest<T> {
    private String url;
    private WeakHashMap<String, Object> params;

    public RetrofitRequest(String url, WeakHashMap<String, Object> params) {
        this.url = url;
        this.params = params;
    }

    public void request(DisposeDataListener<T> listener) {
        Call userCall = RetrofitCreator.getService().get(url, params);
        userCall.enqueue(new CommonCallback<T>(listener));
    }
}
