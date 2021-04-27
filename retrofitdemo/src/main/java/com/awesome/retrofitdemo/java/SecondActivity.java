package com.awesome.retrofitdemo.java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.awesome.retrofitdemo.R;
import com.awesome.retrofitdemo.encapsulation.listener.DisposeDataListener;
import com.awesome.retrofitdemo.test.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit网络请求
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 未封装请求
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://www.imooc.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        APIService apiService = retrofit.create(APIService.class);
//        Call<Teacher> userCall = apiService.getCall("4","10");
//        userCall.enqueue(new Callback<Teacher>() {
//            @Override
//            public void onResponse(Call<Teacher> call, Response<Teacher> response) {
//                List<Course> courses = response.body().getData();
//                for (int i = 0; i < courses.size(); i++) {
//                    Log.i("Retrofit",courses.get(i).toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Teacher> call, Throwable t) {
//                Log.i("Retrofit","onFailure");
//            }
//        });

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