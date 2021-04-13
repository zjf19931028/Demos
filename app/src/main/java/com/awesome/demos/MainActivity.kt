package com.awesome.demos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.awesome.javadomo.threads.ThreadUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ThreadUtil.scheduledThreadPool()
        ThreadUtil.singleThreadScheduledExecutor()
        // 子线程跳转界面
//        findViewById<View>(R.id.tv).setOnClickListener { Thread(Runnable { startActivity(Intent(this@MainActivity, TextViewLinkActivity::class.java)) }).start() }
        findViewById<View>(R.id.tv).setOnClickListener { Toast.makeText(this, "sds", Toast.LENGTH_LONG).show()}
    }
}