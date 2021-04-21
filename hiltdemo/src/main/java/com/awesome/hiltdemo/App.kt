package com.awesome.hiltdemo

import android.app.Application
import com.awesome.sdk.BaseApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/20 17:12
 * Description:
 */
@HiltAndroidApp
class App : BaseApplication() {
    override fun onCreate() {
        super.onCreate()
    }
}