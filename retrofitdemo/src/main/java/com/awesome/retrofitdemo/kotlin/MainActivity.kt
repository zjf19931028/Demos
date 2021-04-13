package com.awesome.retrofitdemo.kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.awesome.retrofitdemo.R
import com.awesome.retrofitdemo.kotlin.entity.Banner
import com.awesome.retrofitdemo.kotlin.model.fetchBannerList
import com.leeeyou.service.subscriber.DefaultHttpResultSubscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchBannerList().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DefaultHttpResultSubscriber<List<Banner>>() {
                    override fun onSuccess(data: List<Banner>?) {
                        Log.i("fetchBannerList",data.toString())
                    }

                    override fun onError(e: Throwable) {
                        super.onError(e)
                        Log.i("fetchBannerList","onError")
                    }

                })

    }
    companion object {


    }
}