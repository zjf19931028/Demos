package com.awesome.demos.test.Activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;

import androidx.annotation.Nullable;

import com.awesome.demos.R;


/**
 * Created by Mjj on 2018/8/8.
 */

public class ServiceActivity3 extends Activity implements View.OnClickListener, ServiceConnection {
    private Intent intent;
    public MyService3.Binder myBinder = null;//①


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(ServiceActivity3.this, MyService1.class);

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
    private Handler hander = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            textView.setText(msg.getData().getString("data"));
        }
    };


    //一旦绑定成功就会执行该函数
    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        myBinder = (MyService3.Binder) iBinder;
        myBinder.getMyService().setCallback(new MyService3.Callback(){
            @Override
            public void onDataChange(String data) {
                Message msg = new Message();
                Bundle b = new Bundle();
                b.putString("data",data);
                msg.setData(b);
                hander.sendMessage(msg);
            }
        });

    }


    @Override
    public void onServiceDisconnected(ComponentName name) {

    }
}
