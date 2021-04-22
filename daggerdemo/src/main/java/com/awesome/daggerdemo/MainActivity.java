package com.awesome.daggerdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.awesome.daggerdemo.Bean.Baozi;
import com.awesome.daggerdemo.Component.DaggerMainComponent;
import com.awesome.sdk.util.ShowLogUtil;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Baozi baozi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.builder()
                .build()
                .inject(this);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowLogUtil.info(baozi.type);
            }
        });
    }
}
