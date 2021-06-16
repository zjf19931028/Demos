package com.awesome.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTvTweenedAnimation;
    private TextView mTvObjectAnimator;
    private TextView mTvViewAnimator;
    private TextView mTvTransition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTweenedAnimation = findViewById(R.id.tv_tweenedAnimation);
        mTvObjectAnimator = findViewById(R.id.tv_objectAnimator);
        mTvViewAnimator = findViewById(R.id.tv_viewAnimator);
        mTvTransition= findViewById(R.id.tv_transition);
        mTvTweenedAnimation.setOnClickListener(this);
        mTvObjectAnimator.setOnClickListener(this);
        mTvViewAnimator.setOnClickListener(this);
        mTvTransition.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()) {
            // ？帧动画，补间动画,<rotate/>
            case R.id.tv_tweenedAnimation:
                intent.setClass(this, TweenedAnimationActivity.class);
                startActivity(intent);
                break;
                //属性动画,ObjectAnimator,AnimatorSet
            case R.id.tv_objectAnimator:
                intent.setClass(this, ObjectAnimatorActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_viewAnimator:
                // 跑马灯,<translate/>
                intent.setClass(this, ViewAnimatorActivity.class);
                startActivity(intent);
                break;
//            case R.id.tv_transition:
//                intent.setClass(this, TransitionActivity.class);
//                intent.putExtra("transition", "slide");
//                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
//                break;
        }
    }
}