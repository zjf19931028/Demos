package com.awesome.okhttpdemo.okhttp.response;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.awesome.okhttpdemo.okhttp.exception.OkHttpException;
import com.awesome.okhttpdemo.okhttp.listener.DisposeDataHandle;
import com.awesome.okhttpdemo.okhttp.listener.DisposeDataListener;
import com.awesome.okhttpdemo.util.ResponseEntityToModule;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/26 16:07
 * Description: 替换源码中的接口及方法
 * 替换源码接口类及其中的方法，防止源码中的接口名和接口中方法名改变
 * step1：创建一个新接口，创建替换旧接口的方法的新方法。
 * step2：创建一个实现类，实现旧接口，并复写旧接口方法
 * step3：操作这个实现类，创建一个属性为新接口，并在构造中赋值，在复写的方法中调用替换的新接口的方法
 * step4：使用实现类和新接口，可以向外抛出新接口对象，并在方法中创建实现类，构造中传入新街口对象
 */
/**
 * Callback封装
 * step1-6:创建自定义回调实体类。使用回调对象，解析实体类。
 */
/**
 * Callback封装
 * step2-3。封装回调的实现类，需要"回调对象"、"解析实体类"。
 */
public class CommonCallback implements Callback {
    protected static final String RESULT_CODE = "ecode";
    protected static final int RESULT_CODE_VALUE = 0;
    protected static final String EMPTY_MSG = "空空如也";

    protected static final int NETWORK_ERROR = 1;
    protected static final int JSON_ERROR = 2;
    protected static final int OTHER_ERROR = 3;
    private DisposeDataListener mListener;
    private Class<?> mClass;

    private Handler mDeliveryHandler;

    /**
     *
     * @param disposeDataHandle  网络请求的返回信息处理
     */
    public CommonCallback(DisposeDataHandle disposeDataHandle) {
        mListener = disposeDataHandle.getListener();
        mClass = disposeDataHandle.getClazz();
        mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    public CommonCallback(DisposeDataListener listener, Class<?> aClass) {
        mListener = listener;
        mClass = aClass;
        mDeliveryHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new OkHttpException(NETWORK_ERROR, e));
            }
        });
    }


    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        String string = response.body().string();

        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(string);
            }
        });
    }


    /**
     * 处理返回信息，不为空转化为json格式
     * @param responseObj
     */
    private void handleResponse(Object responseObj) {
        if (responseObj == null || TextUtils.isEmpty(responseObj.toString().trim())) {
            mListener.onFailure(new OkHttpException(NETWORK_ERROR, EMPTY_MSG));
            return;
        }
        mListener.onSuccess(responseObj);
        return;
//        try {
//            JSONObject result = new JSONObject(responseObj.toString());
//            // 服务器协商部分
////            if (result.has(RESULT_CODE) && result.getInt(RESULT_CODE) == RESULT_CODE_VALUE) {
//                if (mClass == null) {
//                    mListener.onSuccess(result);
//                } else {
//                    Object obj = ResponseEntityToModule.parseJsonObjectToModule(result, mClass);
//                    if (obj != null) {
//                        mListener.onSuccess(obj);
//                    } else {
//                        mListener.onFailure(new OkHttpException(JSON_ERROR, EMPTY_MSG));
//                    }
//                }
////            }else {
////                mListener.onFailure(new OkHttpException(OTHER_ERROR, EMPTY_MSG));
////            }
//        } catch (JSONException e) {
//            mListener.onFailure(new OkHttpException(OTHER_ERROR, e.getMessage()));
//            e.printStackTrace();
//        }
    }
}
