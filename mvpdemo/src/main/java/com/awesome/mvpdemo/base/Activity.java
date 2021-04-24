package com.awesome.mvpdemo.base;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Alice on 2021/4/24
 */
public abstract class Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layId = getContentLayoutId();
        setContentView(layId);
        initBefore();
        initWidget();
        initData();
    }

    protected abstract int getContentLayoutId();

    protected abstract void initBefore();

    protected abstract void initWidget();

    protected abstract void initData();


}