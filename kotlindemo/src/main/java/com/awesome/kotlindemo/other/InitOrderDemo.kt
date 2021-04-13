package com.awesome.kotlindemo.other

import com.awesome.sdk.util.ShowLogUtil

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/9 11:30
 * Description:
 */
class InitOrderDemo(name: String) {
    // 顺序执行属性和初始化块
    val firstProperty = "First property: $name"
    init {
        ShowLogUtil.info("First init block")
    }
    init {
        ShowLogUtil.info("Second init block")
    }
}