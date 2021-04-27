package com.awesome.retrofitdemo.encapsulation.api;

import com.awesome.retrofitdemo.java.Teacher;

import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/13 17:16
 * Description: 请求API 、请求类型
 */
public interface APIService {
    @GET()
    Call<Teacher> get(@Url String url, @QueryMap WeakHashMap<String,Object> hashMap);

    @GET("api/teacher")/*api/teacher?type=4&num=10*/
    Observable<Teacher> getInfoRx(@Query("type") String type, @Query("num")String num);
}
