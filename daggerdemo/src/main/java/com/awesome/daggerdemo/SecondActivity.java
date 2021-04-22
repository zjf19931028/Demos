package com.awesome.daggerdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.awesome.daggerdemo.Bean.Cola;
import com.awesome.daggerdemo.Component.DaggerSecondActivityComponent;
import com.awesome.sdk.util.ShowLogUtil;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    @Inject
    Cola cola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_layout);

        DaggerSecondActivityComponent
                .builder()
                .build()
                .inject(this);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowLogUtil.info(cola.brand);
            }
        });

    }
}
