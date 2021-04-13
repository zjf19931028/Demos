package com.awesome.kotlindemo.other

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/2 09:26
 * Description:
 */
// open可被继承。constructor指定主构造函数
open class Fruit constructor() {
    // 主构造函数的初始化代码
    init {
//        println("I'm a Fruit.")
    }

    // 二级构造函数
    constructor(color: String) : this() {
        println("I'm a Father, my color is $color.");
    }

    // 二级构造函数
    constructor(color: String, name: String) : this() {
        println("I'm a Father, I'm a $name and my color is $color.");
    }
}