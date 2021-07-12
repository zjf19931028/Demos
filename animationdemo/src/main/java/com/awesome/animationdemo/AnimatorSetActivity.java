package com.awesome.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.widget.ImageView;

public class AnimatorSetActivity extends AppCompatActivity {
    private ImageView mIvCloud1, mIvCloud2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        mIvCloud1 = findViewById(R.id.iv_cloud1);
        mIvCloud2 = findViewById(R.id.iv_cloud2);

        // 组合渐变动画,第一种方式
        AnimatorSet animatorSet = new AnimatorSet();
        // with和现有动画同时执行
        // after(Animatior)现有动画插入到传入动画之后执行
        // after(delay)现有动画延迟指定毫秒执行
        // before(Animatior)现有动画插入到传入动画之前执行
        // 先执行动画3，再同时执行动画1、2
        animatorSet.play(ObjectAnimator.ofFloat(mIvCloud1, "scaleX", 1f, 1.5f).setDuration(1000 * 3))
                .with(ObjectAnimator.ofFloat(mIvCloud1, "rotation", 0f, 90f, 0f).setDuration(1000 * 3))
                .after(ObjectAnimator.ofFloat(mIvCloud1, "alpha", 0f, 1f).setDuration(1000 * 3));
        animatorSet.start();

        // 组合渐变动画,第二种方式
        PropertyValuesHolder valuesHolder1 = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.5f);
        PropertyValuesHolder valuesHolder2 = PropertyValuesHolder.ofFloat("rotation", 0.0f, 90.0f, 0.0f);
        PropertyValuesHolder valuesHolder3 = PropertyValuesHolder.ofFloat("alpha", 0.0f, 1f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mIvCloud2, valuesHolder1, valuesHolder2, valuesHolder3);
        objectAnimator.setDuration(1000 * 3).start();

    }
}