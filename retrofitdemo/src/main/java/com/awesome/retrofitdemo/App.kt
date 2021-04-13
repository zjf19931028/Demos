package com.awesome.retrofitdemo

import android.app.Application
import com.awesome.retrofitdemo.kotlin.ServiceFactory
import java.lang.ref.WeakReference

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/13 16:56
 * Description:
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceFactory.DEFAULT_CONTEXT = WeakReference(this)
    }
}