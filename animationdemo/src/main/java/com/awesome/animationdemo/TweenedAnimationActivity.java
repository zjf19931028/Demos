package com.awesome.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

/**
 * 补间动画,<rotate/>
 */
public class TweenedAnimationActivity extends AppCompatActivity {
    private ImageView mIvCloud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweened_animation);
        mIvCloud = findViewById(R.id.iv_rotate);
        // 渐变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setDuration(1000 * 3);
        mIvCloud.startAnimation(alphaAnimation);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIvCloud.clearAnimation();
    }
}