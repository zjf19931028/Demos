package com.awesome.demos.test.Activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.view.View;

import com.awesome.demos.R;

/**
 * Created by Mjj on 2018/8/8.
 */

public class ServiceActivity2 extends Activity implements View.OnClickListener, ServiceConnection {
    private Intent intent;
    public MyService2.Binder myBinder = null;//①


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(ServiceActivity2.this, MyService1.class);

        findViewById(R.id.btyStartService).setOnClickListener(this);
        findViewById(R.id.btyStopService).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btyStartService://启动服务
                if (myBinder != null)
                    myBinder.setData("启动服务了");//③
                break;
            case R.id.btyStopService://终止服务
                stopService(intent);
                break;

        }

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        myBinder = (MyService2.Binder) service;//②

    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
