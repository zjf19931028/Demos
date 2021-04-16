package com.awesome.uidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class LottieActivity extends AppCompatActivity {

    private LottieAnimationView mAnimationView1;
    private LottieAnimationView mAnimationView2;
    private LottieAnimationView mAnimationView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        mAnimationView1 = findViewById(R.id.animation_view1);
        mAnimationView2 = findViewById(R.id.animation_view2);
        mAnimationView3 = findViewById(R.id.animation_view3);
        mAnimationView1.setAnimation("animation/chat_animate.json");
        mAnimationView2.setAnimation("animation/device_animate.json");
        mAnimationView3.setAnimation("animation/me_animate.json");
        mAnimationView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimationView1.playAnimation();
            }
        });
        mAnimationView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimationView2.playAnimation();
            }
        });
        mAnimationView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAnimationView3.playAnimation();
            }
        });
    }
}