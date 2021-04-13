package com.awesome.retrofitdemo.kotlin.model

import com.awesome.retrofitdemo.kotlin.entity.Banner
import com.awesome.retrofitdemo.kotlin.ServiceFactory
import com.awesome.retrofitdemo.kotlin.entity.HttpResultEntity
import com.awesome.retrofitdemo.kotlin.WanAndroidService
import rx.Observable

private const val endPoint = "http://www.wanandroid.com/"

fun fetchBannerList(): Observable<HttpResultEntity<List<Banner>>> {
    return ServiceFactory
            .createRxRetrofitService(WanAndroidService::class.java, endPoint)
            .getBannerList()
}
