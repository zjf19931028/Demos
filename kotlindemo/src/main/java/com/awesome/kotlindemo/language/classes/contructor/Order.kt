package com.awesome.kotlindemo.language.classes.contructor

import com.awesome.sdk.util.ShowLogUtil

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/9 11:30
 * Description:顺序执行属性和初始化块
 */
class Order(name: String) {
    val firstProperty = "First property: $name"
    init {
        ShowLogUtil.info("First init block")
    }
    init {
        ShowLogUtil.info("Second init block")
    }
}