package com.awesome.bluetoothdemo.callbacks;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/2/25 17:08
 * Description:蓝牙连接回调
 */
public interface ConnectBtCallBack {
    void onConnectSuccess();
    void onConnectFail();
}
