package com.awesome.servicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.awesome.sdk.util.ShowLogUtil;

public class MainActivity extends AppCompatActivity {
    private int FLAG_SERVICE_CONNECTION = 0;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ShowLogUtil.info("onServiceConnected");
            MyService.MyBinder binder = (MyService.MyBinder) service;
            int progress = binder.getProgress();
            ShowLogUtil.info("progress=" + progress);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            ShowLogUtil.info("onServiceDisconnected");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
            }
        });
        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                stopService(intent);
            }
        });
        findViewById(R.id.bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService.class);
                bindService(intent, mServiceConnection, FLAG_SERVICE_CONNECTION);

            }
        });
        findViewById(R.id.unbind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    unbindService(mServiceConnection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
