package com.awesome.bluetoothdemo.callbacks;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/2/26 17:56
 * Description:
 */
public interface WriteCallBack {
    void onStart();
    void onFinished(boolean isSuccess,String s);
}
