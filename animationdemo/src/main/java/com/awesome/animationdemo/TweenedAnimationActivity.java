package com.awesome.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * 补间动画,<rotate/>
 */
public class TweenedAnimationActivity extends AppCompatActivity {
    private ImageView mIvRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweened_animation);
        mIvRotate = findViewById(R.id.iv_rotate);
        // 旋转动画
        mIvRotate.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
    }
}