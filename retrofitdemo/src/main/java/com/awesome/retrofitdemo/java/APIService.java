package com.awesome.retrofitdemo.java;

import com.awesome.retrofitdemo.kotlin.entity.Banner;
import com.awesome.retrofitdemo.kotlin.entity.HttpResultEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/13 17:16
 * Description:
 */
public interface APIService {
//    @GET("banner/json")
//    Call<String> getBannerList();

    //http://www.imooc.com/api/teacher?type=4&num=10
    @GET("api/teacher")/*api/teacher?type=4&num=10*/
    Call<Teacher> getCall(@Query("type") String type, @Query("num")String num);
}
