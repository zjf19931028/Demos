package com.awesome.okhttpdemo.app;

import com.awesome.okhttpdemo.okhttp.CommonOkHttpClient;
import com.awesome.okhttpdemo.okhttp.listener.DisposeDataHandle;
import com.awesome.okhttpdemo.okhttp.listener.DisposeDataListener;
import com.awesome.okhttpdemo.okhttp.request.RequestParams;
import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/26 18:30
 * Description: 请求网络中心
 */
public class RequestCenter {
//    /**
//     * 发送一个网络请求
//     *
//     * @param url      网络请求的具体url
//     * @param params   网络请求的参数
//     * @param listener 网络请求的回调
//     * @param aClass   网络请求的返回数据的解析实体类
//     */
//    public static void sendRequest(String url, RequestParams params, DisposeDataListener listener, Class<?> aClass) {
//        CommonOkHttpClient.get(url, params, new DisposeDataHandle(listener, aClass));
//    }

    /**
     * OkHttp封装
     * step1-2:实现登录方法。封装参数类，选择OkHttpClient的get请求，设置真实的url，创建参数类，"传递回调对象"，真实的解析实体类。
     */
    /**
     * OkHttp封装
     * step2-4:实现登录方法。
     */
    /**
     * 请求登录接口
     *
     * @param name     名字参数
     * @param password 密码参数
     * @param listener 请求回调
     */
    public static void login(String name, String password, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("name", name);
        params.put("password", password);
//        sendRequest(HttpConstants.LOGIN_URL, params, listener, null);
        CommonOkHttpClient.get(HttpConstants.LOGIN_URL, params,listener, null);
    }
}
