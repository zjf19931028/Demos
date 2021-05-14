package com.awesome.filedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cocav.tiemu.utils.opus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        opus.getInstance();
    }
}