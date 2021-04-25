package com.awesome.okhttpdemo.okhttp.request;

import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/25 17:34
 * Description:
 */
public class CommonRequest {
    public static Request createPostRequest(String url, RequestParams params) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            Set<Map.Entry<String, String>> entries = params.urlParams.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        return new Request.Builder()
                .url(url)
                .post(builder.build())
                .build();
    }

    public static Request createGetRequest(String url, RequestParams params) {
        StringBuilder stringBuilder = new StringBuilder(url).append("?");
        if (params != null) {
            Set<Map.Entry<String, String>> entries = params.urlParams.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                stringBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
        }
        return new Request.Builder()
                .url(stringBuilder.toString())
                .build();
    }
}
