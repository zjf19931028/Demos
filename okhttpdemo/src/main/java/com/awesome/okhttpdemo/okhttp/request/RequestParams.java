package com.awesome.okhttpdemo.okhttp.request;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/25 17:31
 * Description:请求参数封装
 */
public class RequestParams {
    // ConcurrentHashMap线程安全的HashMap
    public ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value))
            urlParams.put(key, value);
    }
}
