package com.awesome.demos.test.Activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * Created by Mjj on 2018/7/28.
 */

public class SecondActivity extends Activity {

    //声明为静态file
    static int age = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity", "onCreate is invoke");

        //intent要用this的getIntent()获取
        Intent intent = getIntent();
        //用intent.getXXXExtra("key-name")或是intent.getXXXExtra("key-name", default-value)获取值
        String name = intent.getStringExtra("key1");
        int age = intent.getIntExtra("key2", 0);
        Log.d("SecondActivity", name + ":" + age);

        //全局变量
        Toast.makeText(this, "更改后的age = " + ApplicationForFiled.age, Toast.LENGTH_SHORT).show();

        //类静态变量
        Toast.makeText(this, "在ClassStaticActivity中更改了age后的值 = " + age, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SecondActivity", "onStart is invoke");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SecondActivity", "onResume is invoke");

    }
}
