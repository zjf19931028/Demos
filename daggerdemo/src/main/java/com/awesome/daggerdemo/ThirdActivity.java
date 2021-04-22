package com.awesome.daggerdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.awesome.daggerdemo.Bean.CokeCola;
import com.awesome.daggerdemo.Bean.Shuijiao;
import com.awesome.daggerdemo.Component.DaggerThirdActivityComponent;
import com.awesome.daggerdemo.Module.ThirdActivityMoudule;
import com.awesome.sdk.util.ShowLogUtil;

import javax.inject.Inject;

public class ThirdActivity extends AppCompatActivity {

    @Inject
    CokeCola cokeCola;
    @Inject
    Shuijiao shuijiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_layout);

        DaggerThirdActivityComponent.builder()
                .thirdActivityMoudule(new ThirdActivityMoudule("可口可乐","羊肉"))
                .build()
                .inject(this);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowLogUtil.info(cokeCola.brand+shuijiao.type);
            }
        });
    }
}
