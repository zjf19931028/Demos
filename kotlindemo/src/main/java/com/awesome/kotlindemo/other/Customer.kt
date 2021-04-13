package com.awesome.kotlindemo.other

import com.awesome.sdk.util.ShowLogUtil
import java.lang.Exception

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/8 16:51
 * Description:
 */
class Customer(val name: String, val email: String) {

    // 延迟属性
//    val p: String by lazy{
//        // 计算该字符串
//
//    }
    // 函数的默认参数
    fun foo(a: Int = 0, b: String = "") {
        // 创建集合
        val list = listOf(-1, 1, 2, 3)
//        val positives = list.filter { x -> x > 0 }
        val positives = list.filter { it > 0 }
        ShowLogUtil.info(positives)
        // 1..100 闭区间
        // 1 until 100 半开区间，不包含100
        // 创建一个map
        val map = mapOf("a" to 1, "b" to 2, "c" to 3)
        // 遍历map
        for ((k, v) in map)
            ShowLogUtil.info("$k $v")
        // 根据key获取map的value
        ShowLogUtil.info(map["a"])
        val string = getString(-1)
        ShowLogUtil.info(string?.length ?: "empty")
    }

    fun getString(a: Int): String? {
        if (a > 0)
            return "a is valid number"
        return null
    }

    fun tryCatch() {
        val result = try {
            getString(1)
        } catch (e: Exception){
            e.printStackTrace()
        }
    }


}