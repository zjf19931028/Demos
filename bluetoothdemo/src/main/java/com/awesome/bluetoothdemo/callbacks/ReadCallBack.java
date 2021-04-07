package com.awesome.bluetoothdemo.callbacks;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/2/26 17:18
 * Description:
 */
public interface ReadCallBack {
    void onStart();
    void onFinished(boolean isSuccess,String s);
}
