package com.awesome.demos.test.Service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.awesome.demos.R;

/**
 * Created by Mjj on 2018/8/12.
 */

public class ServiceActivity extends Activity {

    private Button mBtn;
    public Intent intent;
    public MyServiceConn myServiceConn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.btn);
        intent = new Intent(this,MyService.class);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent, myServiceConn, Context.BIND_AUTO_CREATE);

//                startService(intent);
            }
        });
    }

    MyService.MyBinder binder = null;
    class MyServiceConn implements ServiceConnection {
        // 服务被绑定成功之后执行
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //service为onBind方法返回的Service实例
            binder = (MyService.MyBinder) service;
        }

        // 服务奔溃或者被杀掉执行
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }
}
