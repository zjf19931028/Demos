package com.awesome.uidemo.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.awesome.uidemo.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jaeger.library.StatusBarUtil;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.btn_jump);

        Glide.with(this)
                .load("/storage/emulated/0/DCIM/Camera/IMG_20201026_172257.jpg") // 加载路径
                .diskCacheStrategy(DiskCacheStrategy.NONE) // 不使用缓存，直接从原图加载
                .centerCrop() // 居中剪切
                .into(imageView);


    }
}