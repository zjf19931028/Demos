package com.awesome.animationdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class TransitionPreActivity extends AppCompatActivity  implements View.OnClickListener {

    private TextView mTvExplode;
    private TextView mTvFade;
    private TextView mTvSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_pre);
        mTvExplode = findViewById(R.id.tv_explode);
        mTvSlide = findViewById(R.id.tv_slide);
        mTvFade = findViewById(R.id.tv_fade);
        mTvExplode.setOnClickListener(this);
        mTvSlide.setOnClickListener(this);
        mTvFade.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId()) {
            case R.id.tv_explode:
                intent.setClass(this, TransitionActivity.class);
                intent.putExtra("transition", "explode");
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.tv_slide:
                intent.setClass(this, TransitionActivity.class);
                intent.putExtra("transition", "slide");
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.tv_fade:
                intent.setClass(this, TransitionActivity.class);
                intent.putExtra("transition", "fade");
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
        }
    }
}