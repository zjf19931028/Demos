package com.awesome.jetpackdemo.component.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.awesome.jetpackdemo.R
import com.awesome.jetpackdemo.databinding.ActivityTestBinding

/**
 * Author: zhangjingfang
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/6/21 8:54 下午
 * Description:类描述
 */
class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val model: ActivityTestBinding = DataBindingUtil.setContentView(this, R.layout.activity_test)
//        model.cartoon = Cartoon()
    }
}