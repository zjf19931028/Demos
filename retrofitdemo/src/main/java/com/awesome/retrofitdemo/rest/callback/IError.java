package com.awesome.retrofitdemo.rest.callback;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/27 18:01
 * Description: 错误回调
 */
public interface IError {
    void onError(int code, String msg);
}
