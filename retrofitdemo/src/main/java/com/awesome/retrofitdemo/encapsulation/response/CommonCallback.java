package com.awesome.retrofitdemo.encapsulation.response;

import com.awesome.retrofitdemo.encapsulation.listener.DisposeDataListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/27 13:55
 * Description: 替换源码的回调接口及方法
 */
public class CommonCallback<T> implements Callback<T> {
    private DisposeDataListener mListener;

    public CommonCallback(DisposeDataListener listener) {
        mListener = listener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        mListener.onSuccess(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }
}
