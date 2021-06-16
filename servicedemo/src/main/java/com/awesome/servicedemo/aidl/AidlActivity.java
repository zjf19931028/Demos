package com.awesome.servicedemo.aidl;

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
import com.awesome.servicedemo.MyService;
import com.awesome.servicedemo.R;

public class AidlActivity extends AppCompatActivity {
    private int FLAG_SERVICE_CONNECTION = 0;
    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ShowLogUtil.info("远程 onServiceConnected");
            //aidl
            IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            try {
                iMyAidlInterface.showProgress();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            ShowLogUtil.info("远程 onServiceDisconnected");

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AidlActivity.this, MyService.class);
                startService(intent);
            }
        });
        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AidlActivity.this, MyService.class);
                stopService(intent);
            }
        });
        findViewById(R.id.bind_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AidlActivity.this, MyService.class);
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