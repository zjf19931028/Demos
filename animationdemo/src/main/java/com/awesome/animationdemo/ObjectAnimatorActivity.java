package com.awesome.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.awesome.animationdemo.widget.MyView;
import com.awesome.sdk.util.ShowLogUtil;

/**
 * 属性动画,ObjectAnimator,AnimatorSet
 */
public class ObjectAnimatorActivity extends AppCompatActivity {

    private ImageView mIvTranslate;
    private ImageView mIvScale;
    private ImageView mIvRotate;
    private ImageView mIvAlpha1;
    private ImageView mIvAlpha2;
    private ImageView mIvAlpha3;
    private ImageView mIvAlpha4;
    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        mIvTranslate = findViewById(R.id.iv_translate);
        mIvScale = findViewById(R.id.iv_scale);
        mIvRotate = findViewById(R.id.iv_rotate);
        mIvAlpha1 = findViewById(R.id.iv_alpha1);
        mIvAlpha2 = findViewById(R.id.iv_alpha2);
        mIvAlpha3 = findViewById(R.id.iv_alpha3);
        mIvAlpha4 = findViewById(R.id.iv_alpha4);
        mBtn = findViewById(R.id.btn);

        // 平移动画
        ObjectAnimator.ofFloat(mIvTranslate, "translationX", 0f, 600).setDuration(1000 * 3).start();
        // 缩放动画
        ObjectAnimator.ofFloat(mIvScale, "scaleX", 1f, 2.2f).setDuration(1000 * 3).start();
        ObjectAnimator.ofFloat(mIvScale, "scaleY", 1f, 2.2f).setDuration(1000 * 3).start();
        // 旋转动画
        ObjectAnimator.ofFloat(mIvRotate, "rotation", 0f, 90f).setDuration(1000 * 3).start();
        // 渐变动画
        ObjectAnimator.ofFloat(mIvAlpha1, "alpha", 1f, 0f).setDuration(1000 * 3).start();
        ObjectAnimator.ofFloat(mIvAlpha2, "alpha", 0f, 1f).setDuration(1000 * 3).start();
        // 组合渐变动画
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(mIvAlpha3, "alpha", 1f, 0f).setDuration(1000 * 3 ))
                .after(ObjectAnimator.ofFloat(mIvAlpha3, "alpha", 0f, 1f).setDuration(1000 * 3));
        animatorSet.start();

        // 动画的监听
        ObjectAnimator animator = ObjectAnimator.ofFloat(mIvAlpha4, "alpha", 1f, 0f).setDuration(1000 * 3);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                ShowLogUtil.info("onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ShowLogUtil.info("onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                ShowLogUtil.info("onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                ShowLogUtil.info("onAnimationRepeat");
            }
        });
        animator.start();

        // 自定义操作属性
        MyView myView = new MyView(mBtn);
        ObjectAnimator.ofInt(myView,"width",500).setDuration(3000).start();
    }
}