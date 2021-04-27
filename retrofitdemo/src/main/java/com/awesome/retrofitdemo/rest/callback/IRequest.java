package com.awesome.retrofitdemo.rest.callback;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/27 18:02
 * Description:
 */
public interface IRequest {
    void onRequestStart();

    void onRequestEnd();
}
