package com.awesome.kotlindemo.language

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.awesome.kotlindemo.R
import com.awesome.kotlindemo.language.classes.Customer
import com.awesome.kotlindemo.language.classes.Face
import com.awesome.kotlindemo.language.classes.contructor.abstracts.Fruit
import com.awesome.kotlindemo.language.classes.contructor.abstracts.Grape
import com.awesome.sdk.util.ShowLogUtil

class ClassesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_classes)

        BaseLanguage().main()
        // 配置对象的属性
        BaseLanguage().apply {
            x = 9
        }

        //制定主构造，不能使用默认构造需要声明，否则不可以使用
//        var c = Customer()
        var customer = Customer("Jane", "23234@qq.com")
        // 关键字with代码块可以直接调用该实例的方法
        with(customer){
            customer.foo()
            ShowLogUtil.info(getString(1))
            ShowLogUtil.info(tryCatch())
        }

//        Fruit();
//        Fruit("violet");
//        Fruit("violet","Grape");
//        Grape("violet")
//        Grape("violet", "Grape")
//        Grape("Shandong");
//        Grape("Shandong","hugePeak");
//        super.getDelegate()

        var face = Face()
        var bean = Face.Bean("happy")
        face.FACE_MAP.put("1",bean)


    }
}