package com.awesome.activitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import com.awesome.sdk.util.ShowLogUtil;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        ArrayList<Fruit> fruits = intent.getParcelableArrayListExtra("fruits");
        for (Fruit f : fruits) {
            ShowLogUtil.info(f.toString());
        }
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                intent.putExtra("fruits", "fruits");
                setResult(1,intent);
                finish();
            }
        });

    }
}