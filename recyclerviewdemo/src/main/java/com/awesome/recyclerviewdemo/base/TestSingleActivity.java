package com.awesome.recyclerviewdemo.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.awesome.recyclerviewdemo.R;

public class TestSingleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_single);
    }
}