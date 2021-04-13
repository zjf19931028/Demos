package com.awesome.retrofitdemo.kotlin.entity;

class HttpResultEntity<T> : BaseEntity<T>() {
    val isSuccess: Boolean
        get() = errorCode == 0
}
