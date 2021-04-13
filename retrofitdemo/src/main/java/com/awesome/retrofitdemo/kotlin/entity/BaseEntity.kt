package com.awesome.retrofitdemo.kotlin.entity;

open class BaseEntity<T> {
    var errorCode: Int = 0
    var errorMsg: String? = null
    var data: T? = null
}
