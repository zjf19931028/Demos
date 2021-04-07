package com.awesome.bluetoothdemo.receiver;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.awesome.bluetoothdemo.BluetoothManager;
import com.awesome.bluetoothdemo.callbacks.ConnectBtCallBack;
import com.awesome.bluetoothdemo.callbacks.ScanBtCallBack;

import java.lang.reflect.Method;

/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/2/23 15:16
 * Description: 蓝牙扫描广播监听器
 */
public class ScanBlueReceiver extends BroadcastReceiver {
    private String pin = "0000";  //此处为你要连接的蓝牙设备的初始密钥，一般为1234或0000
    private ScanBtCallBack mCallBack;

    public ScanBlueReceiver(ScanBtCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
        switch (action) {
            case BluetoothAdapter.ACTION_DISCOVERY_STARTED:
                mCallBack.onScanStarted();
                break;
            case BluetoothAdapter.ACTION_DISCOVERY_FINISHED:
                mCallBack.onScanFinished();
                break;
            case BluetoothDevice.ACTION_FOUND:
                mCallBack.onScanning(device);
                break;
            case BluetoothDevice.ACTION_PAIRING_REQUEST:
                mCallBack.onBondRequest(device);
                try {
                    // 1.确认配对
                    Method setPairingConfirmation = device.getClass().getDeclaredMethod("setPairingConfirmation", boolean.class);
                    setPairingConfirmation.invoke(device, true);
                    // 2.终止有序广播
                    abortBroadcast();
                    // 3.调用setPin方法进行配对
                    Method removeBondMethod = device.getClass().getDeclaredMethod("setPin", new Class[]{byte[].class});
                    Boolean returnValue = (Boolean) removeBondMethod.invoke(device, new Object[]{pin.getBytes()});
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case BluetoothDevice.ACTION_BOND_STATE_CHANGED:
                switch (device.getBondState()) {
                    case BluetoothDevice.BOND_NONE:
                        mCallBack.onBondFail();
                        break;
                    case BluetoothDevice.BOND_BONDING:
                        mCallBack.onBondBonding();
                        break;
                    case BluetoothDevice.BOND_BONDED:
                        mCallBack.onBondSuccess();
                        BluetoothManager.SINGLETON.connect(device, new ConnectBtCallBack() {
                            @Override
                            public void onConnectSuccess() {
//                                ShowLogUtil.info("连接成功");
                            }

                            @Override
                            public void onConnectFail() {
//                                ShowLogUtil.info("连接失败");
                            }
                        });
                        break;
                }
                break;
        }
    }

}
