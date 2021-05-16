package com.awesome.kotlindemo.language

import com.awesome.sdk.util.ShowLogUtil
import java.lang.Exception

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/8 16:48
 * Description:
 */
class BaseLanguage {
    // 关键字val只能赋值一次,相当于final
    val a: Int = 1 //立即赋值
    val b = 2//自动推断出Int类型
//    val c: Int // 错误写法，赋值初始值不可以省略
//    c = 3// 赋值

    // 变量使用var，相当于Object
    var x = 5

    fun main(){
        ShowLogUtil.info(add(1, 2));
        ShowLogUtil.info(sum(2, 2));
        printSum(3, 2)
        x += 1
        ShowLogUtil.info("x = $x")
        if (a > x) {
            ShowLogUtil.info("$a > $x")
        } else {
            ShowLogUtil.info("$a < $x")
        }
        ShowLogUtil.info(getStringLength("123"))
        // 创建集合
        val items = listOf("kiwifruit", "blueberry", "watermelon")
        // foreach循环，关键字for，in
        for (item in items) {
            ShowLogUtil.info("$item")
        }
        // fori循环，关键字for，in
        for (index in items.indices) {
            ShowLogUtil.info("$index I like ${items[index]}")
        }
        // while循环
        var index = 0
        while (index < items.size) {
            ShowLogUtil.info("item at $index is ${items[index]}")
            index++
        }
        // 关键字when相当于switch
        ShowLogUtil.info(describe(1))
        ShowLogUtil.info(describe("Hello"))
        ShowLogUtil.info(describe(3452345234523452345))
        ShowLogUtil.info(describe(2))

        // 关键字in和符号..配合判断是否在指定区间
        if (-1 !in 0..items.lastIndex)
            ShowLogUtil.info("-1 is out of range ${items.lastIndex}")
        if (items.size !in items.indices)
            ShowLogUtil.info("list size is ${items.size} out of valid list indices range ${items.indices}, too")

        // 区间迭代
        for (x in 1..5)
            ShowLogUtil.info(x)
        // 数列迭代
        for (x in 1..10 step 2)
            ShowLogUtil.info(x)
        for (x in 9 downTo 0 step 3)
            ShowLogUtil.info(x)

        // 集合迭代
        for (item in items) {
            ShowLogUtil.info("$item")
        }
        // 运算符in判断集合内是否包含某实例
        when {
            "orange" in items -> ShowLogUtil.info("juicy")
            "kiwifruit" in items -> ShowLogUtil.info("kiwifruit has lots of VC")
        }

        items
                .filter { it.contains("u") }//过滤
                .sortedBy { it }//排序
                .map { it.toUpperCase() }//操作
                .forEach { ShowLogUtil.info(it) }//foreach循环

    }



    // 定义函数格式
    // 关键字fun 函数名(参数名1： 参数类型，参数名2： 参数类型)： 返回类型{
    //      return 值
    // }
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    // 表达式作为函数体，返回值类型自动类型推断
    fun sum(a: Int, b: Int) = a + b

    // Unit类型无意义可以不用返回
    // 双引号中可以使用$参数名使用参数值，使用${}计算表达式
    fun printSum(a: Int, b: Int): Unit {
        println("jlog sum of $a and $b is ${a + b}")
    }

    fun parseInt(str: String): Int? {
        return 0
    }

    // 关键字is可做类型判断，并且使用完成即强转，类型判断类似instanceof
    fun getStringLength(obj: Any): Int? {
        if (obj is String)
            return obj.length
        return null
    }

    fun describe(obj: Any): String =
            // switch case语句
            when (obj) {
                1 -> "one"
                "Hello" -> "Greeting"
                is Long -> "Long"
                else -> "Unknown"
            }



}