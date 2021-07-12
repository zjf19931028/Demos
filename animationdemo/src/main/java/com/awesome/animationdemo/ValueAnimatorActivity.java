package com.awesome.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.awesome.sdk.util.ShowLogUtil;

public class ValueAnimatorActivity extends AppCompatActivity {

    private ImageView mIvCloud1;
    private ValueAnimator mValueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        mIvCloud1 = findViewById(R.id.iv_cloud1);

        mValueAnimator = ValueAnimator.ofFloat(0, 100);
        mValueAnimator.setTarget(mIvCloud1);
        mValueAnimator.setDuration(1000 * 3).start();
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float aFloat = (Float) animation.getAnimatedValue();
                ShowLogUtil.info("aFloat=" + aFloat);
            }
        });



    }
}