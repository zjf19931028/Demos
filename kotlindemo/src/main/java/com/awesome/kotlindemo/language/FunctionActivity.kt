package com.awesome.kotlindemo.language

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.awesome.kotlindemo.R
import com.awesome.sdk.util.ShowLogUtil
import kotlinx.coroutines.*
import okhttp3.Dispatcher

class FunctionActivity : AppCompatActivity() {
    // 定义扩展函数
    fun TextView.isBold() = this.apply {
        paint.isFakeBoldText = true
    }

    var TextView.isBolder: Boolean
        get() {
            return this.paint.isFakeBoldText
        }
        set(value) {
            this.paint.isFakeBoldText = value
        }


    fun add():Int{
        return 123
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function)


        GlobalScope.launch(Dispatchers.Main) {
            val a = withContext(Dispatchers.IO) {
                add()
//                Log.i("launch","1(Thread.currentThread().name="+Thread.currentThread().name)
            }
            Log.i("launch","a="+a)
            Log.i("launch","2(Thread.currentThread().name="+Thread.currentThread().name)
            launch(Dispatchers.IO) {
                Log.i("launch","1(Thread.currentThread().name="+Thread.currentThread().name)
            }
        }


        // 正常调用，加粗字体
        val tv = findViewById<TextView>(R.id.tv)
        tv.paint.isFakeBoldText

        //调用扩展函数
        findViewById<TextView>(R.id.tv).isBold()

        // 调用扩展属性
        findViewById<TextView>(R.id.tv).isBolder = false
    }
}