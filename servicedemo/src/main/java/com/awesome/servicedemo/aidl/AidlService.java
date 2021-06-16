package com.awesome.servicedemo.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.awesome.sdk.util.ShowLogUtil;
import com.awesome.sdk.util.ToastUtils;
import com.awesome.servicedemo.IMyAidlInterface;

/**
 * Author: zhangjingfang
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/6/16 7:34 上午
 * Description:类描述
 */
public class AidlService extends Service {
    private boolean mFlag;
    // 查看服务的进度
    private int mProgress;

    @Override
    public void onCreate() {
        super.onCreate();
        mFlag = true;
        ShowLogUtil.info("远程 onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ShowLogUtil.info("远程 onStartCommand");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(1000);
                        mProgress = i;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ShowLogUtil.info("远程 i=" + i);
                    // 销毁服务时，结束线程中的循环
                    if (!mFlag) break;
                }

            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //aidl
        return new IMyAidlInterface.Stub() {
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

            }

            @Override
            public void showProgress() throws RemoteException {
                ShowLogUtil.info("远程 当前进度=" + mProgress);
            }
        };
    }


    @Override
    public boolean onUnbind(Intent intent) {
        ShowLogUtil.info("远程 onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFlag = false;
        ShowLogUtil.info("远程 onDestroy");
    }
}