package com.awesome.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.awesome.sdk.util.ShowLogUtil
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitOrderDemo("Jane")

//        Beginner().main()
//        var customer = Customer("Jane", "23234@qq.com")
//        // 关键字with代码块可以直接调用该实例的方法
//        with(customer){
//            foo()
//            ShowLogUtil.info(getString(1))
//            ShowLogUtil.info(tryCatch())
//        }
//
//        // 配置对象的属性
//        Beginner().apply {
//            x = 9
//        }
    }

//        Fruit();
//        Fruit("violet");
//        Fruit("violet","Grape");
//        Grape("violet")
//        Grape("violet", "Grape")
//        Grape("Shandong");
//        Grape("Shandong","hugePeak");
//        super.getDelegate()
//        AdvanceLayout(this);
}