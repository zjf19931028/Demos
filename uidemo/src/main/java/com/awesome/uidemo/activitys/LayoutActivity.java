package com.awesome.uidemo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.awesome.sdk.util.ShowLogUtil;
import com.awesome.uidemo.R;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class LayoutActivity extends AppCompatActivity {
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ViewStub viewStub = findViewById(R.id.view_stub);
        findViewById(R.id.btn_controll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    viewStub.setVisibility(View.GONE);
                }else {
                    viewStub.setVisibility(View.VISIBLE);
                }
                flag = !flag;
            }
        });
    }
}