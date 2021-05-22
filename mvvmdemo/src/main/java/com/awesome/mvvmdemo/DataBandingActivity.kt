package com.awesome.mvvmdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.awesome.mvvmdemo.databinding.ActivityDatabandingBinding

/**
 * https://www.jianshu.com/p/8a37af8bfcba
 */
class DataBandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataBinding: ActivityDatabandingBinding = DataBindingUtil.setContentView(this, R.layout.activity_databanding)
        dataBinding.cartoon = Cartoon()
        dataBinding.handler = this
    }
    fun doClick(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}