package com.awesome.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ObjectAnimatorActivity extends AppCompatActivity {

    private ImageView mIvTranslate;
    private ImageView mIvScale;
    private ImageView mIvAlpha1;
    private ImageView mIvAlpha2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        mIvTranslate = findViewById(R.id.iv_translate);
        mIvScale = findViewById(R.id.iv_scale);
        mIvAlpha1 = findViewById(R.id.iv_alpha1);
        mIvAlpha2 = findViewById(R.id.iv_alpha2);

        ObjectAnimator.ofFloat(mIvTranslate, "translationX", 0f, 200).setDuration(1000).start();
        ObjectAnimator.ofFloat(mIvScale, "scaleX", 1f, 1.2f).setDuration(1000).start();
        ObjectAnimator.ofFloat(mIvScale, "scaleY", 1f, 1.2f).setDuration(1000).start();
//        ObjectAnimator.ofFloat(mIvAlpha1, "alpha", 1f, 0f).setDuration(1000).start();
//        ObjectAnimator.ofFloat(mIvAlpha2, "alpha", 0f, 1f).setDuration(1000 * 2).start();

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(mIvAlpha1, "alpha", 1f, 0f).setDuration(1000 * 2))
                .after(ObjectAnimator.ofFloat(mIvAlpha1, "alpha", 0f, 1f).setDuration(1000 * 2));
        animatorSet.start();
    }
}