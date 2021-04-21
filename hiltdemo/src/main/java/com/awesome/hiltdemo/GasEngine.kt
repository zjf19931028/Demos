package com.awesome.hiltdemo

import com.awesome.sdk.util.ShowLogUtil
import javax.inject.Inject

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/20 17:40
 * Description:
 */
class GasEngine @Inject constructor() : Engine {
    override fun start() {
        ShowLogUtil.info("Gas engine start.")
    }

    override fun shutdown() {
        ShowLogUtil.info("Gas engine shutdown.")
    }
}