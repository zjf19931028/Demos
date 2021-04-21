package com.awesome.hiltdemo

import com.awesome.sdk.util.ShowLogUtil
import javax.inject.Inject

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/20 17:43
 * Description:
 */
class ElectricEngine @Inject constructor() : Engine {
    override fun start() {
        ShowLogUtil.info("Electric engine start.")
    }

    override fun shutdown() {
        ShowLogUtil.info("Electric engine start.")
    }

}