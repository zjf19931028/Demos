package com.awesome.kotlindemo

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.awesome.sdk.util.ShowLogUtil
import com.awesome.sdk.util.ToastUtils
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v("jlog", "SplashActivity111")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        tv_appname.setOnClickListener {
            startActivity(Intent(this@SplashActivity, IndexActivity::class.java))
            finish()
        }
        StatusBarUtil.setTranslucent(this)
        lottieAnimationView.playAnimation()
        lottieAnimationView.speed = 1.5F
        lottieAnimationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationEnd(animation: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationCancel(animation: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationStart(animation: Animator?) {
                TODO("Not yet implemented")
                tv_appname.visibility = View.VISIBLE
                startActivity(Intent(this@SplashActivity,IndexActivity::class.java))
                finish()
            }
        })

    }
}