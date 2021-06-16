package com.awesome.demos.test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.awesome.demos.R;
import com.awesome.demos.test.Activity.ClassStaticActivity;
import com.awesome.demos.test.Activity.SecondActivity;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private Button mBtn;
    private Button mBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate is invoke");
        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
        mBtn1 = findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ClassStaticActivity.class);
                startActivity(i);
            }
        });
        new UpdateTextTask(MainActivity.this).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState is invoke");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState is invoke");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart is invoke");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart is invoke");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume is invoke");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause is invoke");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop is invoke");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy is invoke");
    }




}
