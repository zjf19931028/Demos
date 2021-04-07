package com.awesome.bluetoothdemo.receiver;

import android.bluetooth.BluetoothSocket;
import android.os.AsyncTask;
import android.text.TextUtils;


import com.awesome.bluetoothdemo.callbacks.ReadCallBack;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/2/26 17:16
 * Description:
 */
public class ReadTask extends AsyncTask<String, Integer, String> {
    private ReadCallBack callback;
    private BluetoothSocket mBluetoothSocket;

    public ReadTask(ReadCallBack callback, BluetoothSocket socket) {
        this.callback = callback;
        this.mBluetoothSocket = socket;
    }

    @Override
    protected String doInBackground(String... strings) {
        BufferedInputStream in = null;
        try {
            StringBuffer sb = new StringBuffer();
            in = new BufferedInputStream(mBluetoothSocket.getInputStream());
            int length = 0;
            byte[] buf = new byte[1024];
            while ((length = in.read()) != -1) {
                sb.append(new String(buf, 0, length));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "读取失败";
    }

    @Override
    protected void onPreExecute() {
        if (callback != null) callback.onStart();
    }

    @Override
    protected void onPostExecute(String s) {
        if (callback != null) {
            if (TextUtils.equals("读取失败",s)){
                callback.onFinished(false,s);
            }else {
                callback.onFinished(true,s);
            }

        }
    }
}
