package com.awesome.retrofitdemo.rest;

import com.awesome.retrofitdemo.rest.callback.IError;
import com.awesome.retrofitdemo.rest.callback.IFailure;
import com.awesome.retrofitdemo.rest.callback.IRequest;
import com.awesome.retrofitdemo.rest.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/28 10:10
 * Description:
 */
public class RestClientBuilder {
    private String mUrl;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest;
    private ISuccess mISuccess;
    private IFailure mIFailure;
    private IError mIError;
    private RequestBody mBody;

    public RestClientBuilder() {
    }

    /**
     * tip：定义final的方法，内容已经很完善，不希望再被修改
     */
    public final RestClientBuilder url(String url) {
        mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    /**
     * tip：在一个类下，定义方法名时，尽量写得简洁，长的方法名不易阅读。
     */
    public final RestClientBuilder success(ISuccess iSuccess) {
        mISuccess = iSuccess;
        return this;
    }

    /**
     * tip：建造者模式写起来繁琐且程序化
     */
    public final RestClientBuilder failure(IFailure failure) {
        mIFailure = failure;
        return this;
    }

    public final RestClientBuilder error(IError error) {
        mIError = error;
        return this;
    }

    public final RestClientBuilder onRequest(IRequest request) {
        mIRequest = request;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mIRequest, mISuccess, mIFailure, mIError, mBody);
    }


}
