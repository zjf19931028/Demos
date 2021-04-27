package com.awesome.retrofitdemo.rest;

import com.awesome.retrofitdemo.rest.callback.IError;
import com.awesome.retrofitdemo.rest.callback.IFailure;
import com.awesome.retrofitdemo.rest.callback.IRequest;
import com.awesome.retrofitdemo.rest.callback.ISuccess;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/27 17:14
 * Description:
 */
public class RestClient {
    /**
     * final声明的变量没有赋值，必须在构造中赋值
     */
    private final String URL;
    private final Map<String,Object> PARAMS;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;

    public RestClient(String URL, Map<String, Object> PARAMS, IRequest REQUEST,
                      ISuccess SUCCESS, IFailure FAILURE, IError ERROR, RequestBody BODY) {
        this.URL = URL;
        this.PARAMS = PARAMS;
        this.REQUEST = REQUEST;
        this.SUCCESS = SUCCESS;
        this.FAILURE = FAILURE;
        this.ERROR = ERROR;
        this.BODY = BODY;
    }
}
