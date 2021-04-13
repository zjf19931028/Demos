package com.awesome.demos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;

import com.awesome.javadomo.threads.ThreadUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ThreadUtil.scheduledThreadPool();
        ThreadUtil.singleThreadScheduledExecutor();
        // 子线程跳转界面
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, TextViewLinkActivity.class));
                    }
                }).start();
            }
        });
    }
}
