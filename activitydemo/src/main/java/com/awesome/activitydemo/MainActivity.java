package com.awesome.activitydemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.awesome.sdk.util.ShowLogUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 构建集合数据
        List<Fruit> fruits = new ArrayList<>();
        Fruit fruit = new Fruit("apple", Color.RED);
        fruits.add(fruit);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 有返回信息的跳转页面
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putParcelableArrayListExtra("fruits", (ArrayList<? extends Parcelable>) fruits);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String fruits = data.getStringExtra("fruits");
        ShowLogUtil.info("fruits="+fruits);
    }
}