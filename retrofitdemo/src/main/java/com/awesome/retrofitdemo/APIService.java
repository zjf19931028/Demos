package com.awesome.retrofitdemo;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/8 18:12
 * Description:
 */
public interface APIService {
    @POST
    Call<String> getUser();
}
