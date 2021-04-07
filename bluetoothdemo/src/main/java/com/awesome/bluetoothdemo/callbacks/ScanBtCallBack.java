package com.awesome.bluetoothdemo.callbacks;

import android.bluetooth.BluetoothDevice;

/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/2/23 15:19
 * Description: 蓝牙扫描回调
 */
public interface ScanBtCallBack {
    void onScanStarted();
    void onScanFinished();
    void onScanning(BluetoothDevice device);
    void onBondRequest(BluetoothDevice device);
    void onBondFail();
    void onBondBonding();
    void onBondSuccess();
}
