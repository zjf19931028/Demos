package com.awesome.bluetoothdemo.receiver;

import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.awesome.bluetoothdemo.callbacks.WriteCallBack;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/2/26 17:56
 * Description:
 */
public class WriteTask extends AsyncTask<String, Integer, String> {
    private WriteCallBack mCallBack;
    private BluetoothSocket mBluetoothSocket;

    public WriteTask(WriteCallBack callBack, BluetoothSocket bluetoothSocket) {
        mCallBack = callBack;
        mBluetoothSocket = bluetoothSocket;
    }

    @Override
    protected String doInBackground(String... strings) {
        String string = strings[0];
        OutputStream out = null;
        try {
            mBluetoothSocket.getOutputStream();
            out.write(string.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "发送成功";
    }

    @Override
    protected void onPreExecute() {
        if (mCallBack != null) mCallBack.onStart();
    }

    @Override
    protected void onPostExecute(String s) {
        if (mCallBack != null) {
            if (TextUtils.equals("发送成功",s)){
                mCallBack.onFinished(false,s);
            }else {
                mCallBack.onFinished(true,s);
            }
        }

    }
}
