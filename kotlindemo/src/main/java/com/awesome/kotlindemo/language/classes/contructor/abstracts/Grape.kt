package com.awesome.kotlindemo.language.classes.contructor.abstracts

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/2 09:53
 * Description:
 */
// 不指定主构造函数，都是二级构造函数
class Grape : Fruit {
    // 二级构造函数
    constructor(color: String) {
        println("I'm a sub, my color is $color.");
    }

    // 二级构造函数
    constructor(color: String, name: String) : super(color, name) {
        println("I'm a sub, I'm a $name and my color is $color.");
    }
}



//    // 二级构造函数
//    constructor(growth: String) {
//        println("My growth is $growth.");
//    }
//
//
//    // 二级构造函数
//    constructor(growth: String, varieties: String) : super(growth) {
//        println("My growth is $varieties and my varieties is $growth.");
//    }