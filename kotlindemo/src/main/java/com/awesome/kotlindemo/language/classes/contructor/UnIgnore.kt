package com.awesome.kotlindemo.language.classes.contructor

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/9 11:43
 * Description:
 */
// 有修饰符或注解时，不可以省略constructor
class UnIgnore public constructor(name: String) {
    val customerKey = name.toUpperCase()
}