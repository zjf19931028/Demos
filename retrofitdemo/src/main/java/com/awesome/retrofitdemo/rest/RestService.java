package com.awesome.retrofitdemo.rest;

import java.util.Map;
import java.util.WeakHashMap;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/27 17:14
 * Description: 请求类
 * 推荐：图解http
 */
public interface RestService {
    @GET
    Call<String> get(@Url String url, @QueryMap WeakHashMap<String,Object> map);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap WeakHashMap<String,Object> map);

    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap WeakHashMap<String, Object> params);

    @DELETE
    Call<String> delete(@Url String url, @QueryMap WeakHashMap<String,Object> map);

}
