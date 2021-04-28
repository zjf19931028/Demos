package com.awesome.retrofitdemo.encapsulation.listener;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/27 13:56
 * Description: tip 替换源码中的回调1：替换源码中的回调
 */
public interface DisposeDataListener<T>{
    void onSuccess(T responseObj);
    void onFailure(Object reasonObj);
}
