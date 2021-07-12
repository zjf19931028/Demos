package com.awesome.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class XmlAnimatorActivity extends AppCompatActivity {
    private ImageView mIvCloud1,mIvCloud2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_animator);
        mIvCloud1 = findViewById(R.id.iv_cloud1);
        mIvCloud2 = findViewById(R.id.iv_cloud2);

        // 旋转动画1,View动画
        mIvCloud1.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));

        // 旋转动画2,属性动画
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotate);
        animator.setTarget(mIvCloud2);
        animator.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mIvCloud1.clearAnimation();
    }
}