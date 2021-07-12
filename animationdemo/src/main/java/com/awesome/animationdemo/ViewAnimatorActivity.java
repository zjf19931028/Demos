package com.awesome.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ViewAnimator;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 跑马灯,<translate/>
 */
public class ViewAnimatorActivity extends AppCompatActivity {

    private ViewAnimator mViewAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animator);
        mViewAnimator = findViewById(R.id.viewAnimator);
        mViewAnimator.setInAnimation(this,R.anim.slide_in_down);
        mViewAnimator.setOutAnimation(this,R.anim.slide_out_up);
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                mViewAnimator.post(new Runnable() {
                    @Override
                    public void run() {
                        mViewAnimator.showNext();
                    }
                });
            }
        },1,1, TimeUnit.SECONDS);
    }
}