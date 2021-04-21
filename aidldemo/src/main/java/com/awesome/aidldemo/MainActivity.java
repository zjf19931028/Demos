package com.awesome.aidldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.awesome.sdk.util.ShowLogUtil;
import com.awesome.servicedemo.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    private int FLAG_SERVICE_CONNECTION = 0;
    ServiceConnection conn=new ServiceConnection(){

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ShowLogUtil.info("conn onServiceConnected");

//            IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
//            try {
//                iMyAidlInterface.showPregress();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            ShowLogUtil.info("conn onServiceDisconnected");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //远程启动服务
                Intent intent = new Intent("com.awesome.myservice");
                intent.setPackage("com.awesome.servicedemo");
                startService(intent);
            }
        });
        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.awesome.myservice");
                intent.setPackage("com.awesome.servicedemo");
                stopService(intent);
            }
        });
        findViewById(R.id.bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.awesome.myservice");
                intent.setPackage("com.awesome.servicedemo");
                bindService(intent,conn,FLAG_SERVICE_CONNECTION);
            }
        });
        findViewById(R.id.unbind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);

            }
        });
    }
}