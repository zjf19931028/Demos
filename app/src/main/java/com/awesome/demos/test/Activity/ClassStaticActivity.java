package com.awesome.demos.test.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.awesome.demos.R;


/**
 * Created by Mjj on 2018/7/28.
 */

public class ClassStaticActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        SecondActivity.age = 23;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //到SecondActivity中查看对age更改是否有效
                Intent intent = new Intent(ClassStaticActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
