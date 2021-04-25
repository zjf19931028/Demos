package com.awesome.viewpagerdemo.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.awesome.viewpagerdemo.R;

public class ViewpagerActivity2 extends AppCompatActivity {

    private ViewPager2 mViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager2);
        mViewPager2 = findViewById(R.id.viewPager2);
        mViewPager2.setAdapter(new ViewPagerAdapter());
    }
}