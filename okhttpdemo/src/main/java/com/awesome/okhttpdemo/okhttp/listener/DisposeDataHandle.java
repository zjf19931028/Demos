package com.awesome.okhttpdemo.okhttp.listener;

import androidx.annotation.NonNull;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/26 18:22
 * Description:
 */
public class DisposeDataHandle {
    private DisposeDataListener mListener;
    private Class<?> mClass;

    public DisposeDataHandle(DisposeDataListener listener) {
        mListener = listener;
    }

    /**
     * 重载构造方法
     * @param listener 回调监听
     * @param aClass   数据解析实体类
     */
    public DisposeDataHandle(DisposeDataListener listener, Class<?> aClass) {
        mListener = listener;
        mClass = aClass;
    }

    public DisposeDataListener getListener() {
        return mListener;
    }


    public Class<?> getClazz() {
        return mClass;
    }
}
