package com.awesome.bluetoothdemo;

import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;

import androidx.fragment.app.FragmentActivity;

import com.awesome.bluetoothdemo.callbacks.ConnectBtCallBack;
import com.awesome.bluetoothdemo.receiver.ConnectBlueTask;

import java.lang.reflect.Method;

/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/2/23 14:26
 * Description: 蓝牙管理类
 */
public enum BluetoothManager {
    SINGLETON;
    private BluetoothAdapter mBluetoothAdapter;

    BluetoothManager() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public boolean isSupport() {
        return mBluetoothAdapter != null;
    }

    public boolean isEnable() {
        return isSupport() && mBluetoothAdapter.isEnabled();
    }

    public void openBtAsyn() {
        if (isSupport()) {
            mBluetoothAdapter.enable();
        }
    }

    public void openBtSync(FragmentActivity context) {
        if (isSupport()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            context.startActivityForResult(enableBtIntent, 0);
        }
    }

    public boolean checkGPSIsOpen() {
        LocationManager locationManager = (LocationManager) App.getInstance().getSystemService(Context.LOCATION_SERVICE);
        if (locationManager == null) return false;
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public void openGPS(final FragmentActivity context) {
        new AlertDialog.Builder(context)
                .setTitle("提示")
                .setMessage("当前手机扫描蓝牙需要打开定位功能。")
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                context.finish();
                            }
                        })
                .setPositiveButton("前往设置",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                context.startActivityForResult(intent, 0);
                            }
                        })

                .setCancelable(false)
                .show();
    }

    public void scanBt() {
        if (!isEnable()) return;
        if (mBluetoothAdapter.isDiscovering()) {
            mBluetoothAdapter.cancelDiscovery();
        }
        mBluetoothAdapter.startDiscovery();
    }

    public void cancelScanBt() {
        if (isSupport() && mBluetoothAdapter.isDiscovering()) {
            mBluetoothAdapter.cancelDiscovery();
        }
    }

    /**
     * 配对
     *
     * @param device
     */
    public void pin(BluetoothDevice device) {
        if (device == null) return;
        if (!isEnable()) return;
        cancelScanBt();
        // 如果没有配对才去配对
        if (device.getBondState() == BluetoothDevice.BOND_NONE) {
            try {
                Method createBondMethod = device.getClass().getMethod("createBond");
                Boolean returnValue = (Boolean) createBondMethod.invoke(device);
                returnValue.booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void cancelPinBt(BluetoothDevice device) {
        if (device == null) return;
        if (!isEnable()) return;
        // 如果没有配对就不用取消配对了
        if (device.getBondState() != BluetoothDevice.BOND_NONE) {
            try {
                Method createBondMethod = device.getClass().getMethod("createBond");
                Boolean returnValue = (Boolean) createBondMethod.invoke(device);
                returnValue.booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 连接 (配对之后调用)
     *
     * @param device
     * @param callBack
     */
    public void connect(BluetoothDevice device, ConnectBtCallBack callBack) {
        if (device == null) return;
        if (!isEnable()) return;
        cancelScanBt();
        new ConnectBlueTask(callBack).execute(device);
    }

    public void connectMAC(String address, ConnectBtCallBack callBack) {
        if (!isEnable()) return;
        BluetoothDevice bluetoothDevice = mBluetoothAdapter.getRemoteDevice(address);
        connect(bluetoothDevice, callBack);

    }


}
