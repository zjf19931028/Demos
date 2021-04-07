package com.awesome.bluetoothdemo.receiver;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;

import com.awesome.bluetoothdemo.callbacks.ConnectBtCallBack;

import java.io.IOException;
import java.util.UUID;

/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/2/24 13:49
 * Description:
 */
public class ConnectBlueTask extends AsyncTask<BluetoothDevice, Integer, BluetoothSocket> {
    private BluetoothDevice mBluetoothDevice;
    private ConnectBtCallBack mCallBack;
    private BluetoothSocket mBluetoothSocket = null;

    public ConnectBlueTask(ConnectBtCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    protected BluetoothSocket doInBackground(BluetoothDevice... bluetoothDevices) {
        mBluetoothDevice = bluetoothDevices[0];
        try {
            mBluetoothSocket = mBluetoothDevice.createRfcommSocketToServiceRecord(UUID.randomUUID());
            if (mBluetoothSocket != null && !mBluetoothSocket.isConnected()){
//                ShowLogUtil.info("开始连接 connect");
                mBluetoothSocket.connect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (mBluetoothSocket != null)
                    mBluetoothSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return mBluetoothSocket;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        ShowLogUtil.info("开始连接");
    }

    @Override
    protected void onPostExecute(BluetoothSocket bluetoothSocket) {
//        ShowLogUtil.info("bluetoothSocket.isConnected()=" + bluetoothSocket.isConnected());
        if (bluetoothSocket != null && bluetoothSocket.isConnected()) {
            if (mCallBack != null) mCallBack.onConnectSuccess();
        } else {
            if (mCallBack != null) mCallBack.onConnectFail();
        }
    }

    /**
     * 断开连接
     *
     * @return
     */
    public boolean cancelConnect() {
        if (mBluetoothSocket != null && mBluetoothSocket.isConnected()) {
            try {
                mBluetoothSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        mBluetoothSocket = null;
        return true;
    }
}
