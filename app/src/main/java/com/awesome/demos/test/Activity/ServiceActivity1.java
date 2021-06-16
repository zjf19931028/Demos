package com.awesome.demos.test.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.awesome.demos.R;


/**
 * Created by Mjj on 2018/8/8.
 */

public class ServiceActivity1 extends Activity implements View.OnClickListener {
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(ServiceActivity1.this, MyService1.class);

        findViewById(R.id.btyStartService).setOnClickListener(this);
        findViewById(R.id.btyStopService).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btyStartService://启动服务
                intent.putExtra("data", "data");
                startService(intent);
                break;
            case R.id.btyStopService://终止服务
                stopService(intent);
                break;

        }

    }
}
