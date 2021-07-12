package com.awesome.animationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * View动画：
 * 1.代码实现AlphaAnimation、RotateAnimation、TranslateAnimation、ScaleAnimation
 * 2.xml实现 anim包下的标签<alpha/><rotate/><translate/><scale/> 对View执行AnimationUtils.loadAnimation
 * 属性动画：
 * 1.代码实现ObjectAnimator:alpha、rotation、rotationX、rotationY、translationX、translationY、scaleX、scaleY
 * 2.xml实现 animator包下的标签<objectAnimator/> 设置目标View AnimatorInflater.loadAnimator
 * 组合动画：
 * 1.AnimatorSet 可以有先后执行顺序的属性动画
 * 2.PropertyValuesHolder 同时执行一组属性动画
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTvTweenedAnimation;
    private TextView mTvXmlAnimator;
    private TextView mTvViewAnimator;
    private TextView mTvObjectAnimator;
    private TextView mTvValueAnimator;
    private TextView mTvAnimatorSet;
    private TextView mTvTransition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvTweenedAnimation = findViewById(R.id.tv_tweenedAnimation);
        mTvXmlAnimator = findViewById(R.id.tv_xmlAnimator);
        mTvViewAnimator = findViewById(R.id.tv_viewAnimator);
        mTvObjectAnimator = findViewById(R.id.tv_objectAnimator);
        mTvValueAnimator = findViewById(R.id.tv_valueAnimator);
        mTvAnimatorSet = findViewById(R.id.tv_animatorSet);
        mTvTransition= findViewById(R.id.tv_transition);

        mTvTweenedAnimation.setOnClickListener(this);
        mTvXmlAnimator.setOnClickListener(this);
        mTvViewAnimator.setOnClickListener(this);
        mTvObjectAnimator.setOnClickListener(this);
        mTvValueAnimator.setOnClickListener(this);
        mTvAnimatorSet.setOnClickListener(this);
        mTvTransition.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()) {
            case R.id.tv_tweenedAnimation:
                // AlphaAnimation、RotateAnimation、TranslateAnimation、ScaleAnimation
                intent.setClass(this, TweenedAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_xmlAnimator:
                // anim包下的标签<alpha/><rotate/><translate/><scale/> 对View执行AnimationUtils.loadAnimation
                // animator包下的标签<objectAnimator/> 设置目标View AnimatorInflater.loadAnimator
                intent.setClass(this, XmlAnimatorActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_viewAnimator:
                // 跑马灯ViewAnimator
                intent.setClass(this, ViewAnimatorActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_objectAnimator:
                //属性动画ObjectAnimator:alpha、rotation、rotationX、rotationY、translationX、translationY、scaleX、scaleY
                intent.setClass(this, ObjectAnimatorActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_valueAnimator:
                // 数值发生器ValueAnimator
                intent.setClass(this, ValueAnimatorActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_animatorSet:
                // 组合动画AnimatorSet、PropertyValuesHolder
                intent.setClass(this, AnimatorSetActivity.class);
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