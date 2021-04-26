package com.awesome.okhttpdemo.okhttp.listener;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/26 15:57
 * Description: 网络请求回调
 */
public interface DisposeDataListener {
    /**
     * 请求成功回调
     * @param responseObj
     */
    void onSuccess(Object responseObj);

    /**
     * 请求失败回调
     * @param reasonObj
     */
    void onFailure(Object reasonObj);
}
