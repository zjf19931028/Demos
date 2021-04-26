package com.awesome.okhttpdemo.app;

import com.awesome.okhttpdemo.okhttp.CommonOkHttpClient;
import com.awesome.okhttpdemo.okhttp.listener.DisposeDataHandle;
import com.awesome.okhttpdemo.okhttp.listener.DisposeDataListener;
import com.awesome.okhttpdemo.okhttp.request.RequestParams;
import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/26 18:30
 * Description:
 */
public class RequestCenter {
    public static void sendRequest(String url, RequestParams params, DisposeDataListener listener, Class<?> aClass) {
        CommonOkHttpClient.get(url, null,
                new DisposeDataHandle(new DisposeDataListener() {
                    @Override
                    public void onSuccess(Object responseObj) {
                        ShowLogUtil.info("onSuccess");
                        ShowLogUtil.info(responseObj.toString());
                    }

                    @Override
                    public void onFailure(Object reasonObj) {
                        ShowLogUtil.info("onFailure");
                        ShowLogUtil.info(reasonObj.toString());
                    }
                }));
    }

    public static void login(String name, String password, DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("name", name);
        params.put("password", password);
        sendRequest(HttpConstants.LOGIN_URL, params, listener, null);
    }
}
