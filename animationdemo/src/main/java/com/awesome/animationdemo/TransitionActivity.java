package com.awesome.animationdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.transition.Explode;
import androidx.transition.Fade;
import androidx.transition.Slide;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.awesome.animationdemo.R;

public class TransitionActivity extends AppCompatActivity {

    private ImageView mImageView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

//        mImageView = findViewById(R.id.iv);
//        String transition=getIntent().getStringExtra("transition");
//        switch (transition) {
//            case "explode":
//                mImageView.setBackgroundColor(Color.RED);
//                Explode explode = new Explode();
//                explode.setDuration(1000L);
//                getWindow().setEnterTransition(explode);
//                break;
//            case "slide":
//                mImageView.setBackgroundColor(Color.YELLOW);
//                Slide slide = new Slide(Gravity.BOTTOM);
//                slide.setDuration(1000L);
//                getWindow().setEnterTransition(slide);
//                break;
//            case "fade":
//                mImageView.setBackgroundColor(Color.BLUE);
//                Fade fade = new Fade();
//                fade.setDuration(1000L);
//                getWindow().setEnterTransition(fade);
//                break;
//        }
    }
}