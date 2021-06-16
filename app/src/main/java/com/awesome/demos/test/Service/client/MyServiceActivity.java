package com.awesome.demos.test.Service.client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.awesome.demos.R;

import java.util.List;
import java.util.Random;

/**
 * Created by Mjj on 2018/8/15.
 */

public class MyServiceActivity extends Activity {

    private Button mBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent1 = new Intent(getApplicationContext(), MyAidlService.class);
//                bindService(intent1, mConnection, BIND_AUTO_CREATE);
//                addPerson();
            }
        });

    }

//    private IMyAidl mAidl;
//
//    private ServiceConnection mConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            //连接后拿到 Binder，转换成 AIDL，在不同进程会返回个代理
//            mAidl = IMyAidl.Stub.asInterface(service);
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            mAidl = null;
//        }
//    };
//
//    List<Person> personList;

//    public void addPerson() {
//        Random random = new Random();
//        Person person = new Person("shixin" + random.nextInt(10));
//
//        try {
//            mAidl.addPerson(person);
//            personList = mAidl.getPersonList();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }
}
