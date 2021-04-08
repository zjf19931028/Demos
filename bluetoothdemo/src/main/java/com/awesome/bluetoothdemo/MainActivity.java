package com.awesome.bluetoothdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;

import com.awesome.bluetoothdemo.callbacks.ScanBtCallBack;
import com.awesome.bluetoothdemo.receiver.ScanBlueReceiver;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    private void doBluetooth() {
//        if (!hasPermission(LOCATION_PERMISSION)) {
//            requestPermission(Constant.LOCATION_CODE, LOCATION_PERMISSION);
//        }
//        boolean isSupport = android.bluetooth.BluetoothManager.SINGLETON.isSupport();
//        boolean isEnable = android.bluetooth.BluetoothManager.SINGLETON.isEnable();
//        boolean checkGPSIsOpen = android.bluetooth.BluetoothManager.SINGLETON.checkGPSIsOpen();
//        ShowLogUtil.info("isSupport=" + isSupport);
//        ShowLogUtil.info("isEnable=" + isEnable);
//        ShowLogUtil.info("checkGPSIsOpen=" + checkGPSIsOpen);
//        if (!isEnable) {
//            android.bluetooth.BluetoothManager.SINGLETON.openBtAsyn();
//        }
//        if (!checkGPSIsOpen) {
//            android.bluetooth.BluetoothManager.SINGLETON.openGPS(this);
//        }
//        ScanBlueReceiver scanBlueReceiver = new ScanBlueReceiver(new ScanBtCallBack() {
//            @Override
//            public void onScanStarted() {
//                ShowLogUtil.info("开始扫描");
//            }
//
//            @Override
//            public void onScanFinished() {
//                ShowLogUtil.info("结束扫描");
//            }
//
//            @Override
//            public void onScanning(BluetoothDevice device) {
//                if (!TextUtils.isEmpty(device.getName()))
//                    ShowLogUtil.info("device=" + device.getName());
//                if (TextUtils.equals("“张竟方”的 iPhone", device.getName())) {
//                    android.bluetooth.BluetoothManager.SINGLETON.pin(device);
//                }
////                if (!TextUtils.isEmpty(device.getName()))
////                    ShowLogUtil.info("device=" + device.getName());
////                if (TextUtils.equals("张竟方的iPhone", device.getName())) {
////                    BluetoothManager.SINGLETON.pin(device);
////                    BluetoothManager.SINGLETON.cancelPinBt(device);
////                }
//            }
//
//            @Override
//            public void onBondRequest(BluetoothDevice device) {
//                ShowLogUtil.info("配对请求");
//
//            }
//
//            @Override
//            public void onBondFail() {
//                ShowLogUtil.info("配对失败");
//            }
//
//            @Override
//            public void onBondBonding() {
//                ShowLogUtil.info("配对中");
//            }
//
//            @Override
//            public void onBondSuccess() {
//                ShowLogUtil.info("配对成功");
//            }
//
//        });
//        IntentFilter filter1 = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
//        IntentFilter filter2 = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
//        IntentFilter filter3 = new IntentFilter(BluetoothDevice.ACTION_FOUND);
//        IntentFilter filter4 = new IntentFilter(BluetoothDevice.ACTION_PAIRING_REQUEST);
//        IntentFilter filter5 = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
//        registerReceiver(scanBlueReceiver, filter1);
//        registerReceiver(scanBlueReceiver, filter2);
//        registerReceiver(scanBlueReceiver, filter3);
//        registerReceiver(scanBlueReceiver, filter4);
//        registerReceiver(scanBlueReceiver, filter5);
//        BluetoothManager.SINGLETON.scanBt();
//    }
//
//    private void doFile() {
//        File file = FileUtil.createFile();
////        FileUtil.byteWrite(file);
////        FileUtil.byteRead(file);
////        FileUtil.delete(file);
//        ShowLogUtil.info("file.getAbsolutePath()=" + file.getAbsolutePath());
//
//
////        File newFile = FileUtil.createFile();
////        FileUtil.byteReadToWrite(file, newFile);
////        FileUtil.stringWrite(file);
////        FileUtil.stringRead(file);
////        File newFile = FileUtil.createFile();
////        FileUtil.stringReadToWrite(file, newFile);
//    }
}