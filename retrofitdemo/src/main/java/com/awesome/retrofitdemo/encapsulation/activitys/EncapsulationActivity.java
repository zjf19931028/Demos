package com.awesome.retrofitdemo.encapsulation.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.awesome.retrofitdemo.R;
import com.awesome.retrofitdemo.encapsulation.listener.DisposeDataListener;
import com.awesome.retrofitdemo.java.Teacher;
import com.awesome.retrofitdemo.test.Network;
import com.awesome.sdk.util.ShowLogUtil;

public class EncapsulationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encapsulation);

        // 封装创建及设置Retrofit
//        APIService apiService = CommonRetrofit.mRetrofit.create(APIService.class);
//        Call<Teacher> userCall = apiService.getCall("4", "10");
//        userCall.enqueue(new CommonCallback(new DisposeDataListener() {
//            @Override
//            public void onSuccess(Object responseObj) {
//                Log.i("Retrofit",responseObj.toString());
//            }
//
//            @Override
//            public void onFailure(Object reasonObj) {
//                Log.i("Retrofit",reasonObj.toString());
//            }
//        }));

        // 封装创建及设置Retrofit、接口api、返回回调
        new Network().getList("4","10",new DisposeDataListener<Teacher>(){

            @Override
            public void onSuccess(Teacher responseObj) {
                ShowLogUtil.info("onSuccess");
                for (int i = 0; i < responseObj.getData().size(); i++) {
                    Log.i("Retrofit",responseObj.getData().get(i).toString());
                }
            }

            @Override
            public void onFailure(Object reasonObj) {
                Log.i("Retrofit","onFailure");
                Log.i("Retrofit",reasonObj.toString());
            }
        });
    }
}