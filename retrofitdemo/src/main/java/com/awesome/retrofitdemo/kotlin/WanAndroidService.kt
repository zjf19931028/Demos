package com.awesome.retrofitdemo.kotlin

import com.awesome.retrofitdemo.kotlin.entity.Banner
import com.awesome.retrofitdemo.kotlin.entity.HttpResultEntity
import retrofit2.http.GET
import rx.Observable

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/13 16:30
 * Description:
 */
interface WanAndroidService {
    @GET("banner/json")
    fun getBannerList(): Observable<HttpResultEntity<List<Banner>>>
}