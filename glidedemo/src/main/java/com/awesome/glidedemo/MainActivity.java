package com.awesome.glidedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load("http://img.mukewang.com/55249cf30001ae8a06000338-300-170.jpg")
                .centerCrop()
                .into(imageView);

    }
}