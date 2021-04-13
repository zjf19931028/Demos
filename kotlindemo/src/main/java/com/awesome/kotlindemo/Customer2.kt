package com.awesome.kotlindemo

import androidx.annotation.IntDef
import java.lang.annotation.Inherited

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/9 11:43
 * Description:
 */
// 有修饰符或注解时，不可以省略constructor
class Customer2 public constructor(name: String) {
    val customerKey = name.toUpperCase()
}