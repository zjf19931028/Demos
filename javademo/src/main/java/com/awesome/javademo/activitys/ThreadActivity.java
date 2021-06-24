package com.awesome.javademo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.awesome.javademo.R;
import com.awesome.javademo.threads.CompareThread;
import com.awesome.javademo.threads.FutureTaskExample;

import java.util.concurrent.FutureTask;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
//        CompareThread.compareAsync();
        CompareThread.compareSync();
    }
}