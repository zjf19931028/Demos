package com.awesome.contentresoverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ContentResolver mContentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContentResolver = getContentResolver();
//        mContentResolver.query();
//        mContentResolver.insert()
//        mContentResolver.delete()
//        mContentResolver.update()
    }
}