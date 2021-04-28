package com.awesome.retrofitdemo.rest.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.awesome.retrofitdemo.R;
import com.awesome.retrofitdemo.rest.RestClient;
import com.awesome.retrofitdemo.rest.callback.IError;
import com.awesome.retrofitdemo.rest.callback.IFailure;
import com.awesome.retrofitdemo.rest.callback.ISuccess;

public class RestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
        testRestClient();
    }

    /**
     * 测试RestClient
     */
    private void testRestClient(){
        /**
         * tip：构建者模式特点，流水线。代码看起来整洁，简单。
         */
        RestClient.builder()
                .url("api/teacher")
                .params("type","4")
                .params("num","10")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Log.i("Retrofit","onSuccess");
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                        Log.i("Retrofit","onFailure");

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                        Log.i("Retrofit","onError");

                    }
                })
                .build()
                .get();
    }
}