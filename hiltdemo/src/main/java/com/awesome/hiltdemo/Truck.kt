package com.awesome.hiltdemo

import android.util.Log
import com.awesome.sdk.util.ShowLogUtil
import javax.inject.Inject

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/20 17:14
 * Description:
 */
class Truck @Inject constructor(val driver:Driver){
    @BindGasEngine
    @Inject
    lateinit var gasEngine: Engine

    @BindElectricEngine
    @Inject
    lateinit var electricEngine: Engine

    fun deliver() {
        gasEngine.start()
        electricEngine.start()
        ShowLogUtil.info("Truck is delivering cargo.Driven by $driver")
        gasEngine.shutdown()
        electricEngine.shutdown()
    }
}