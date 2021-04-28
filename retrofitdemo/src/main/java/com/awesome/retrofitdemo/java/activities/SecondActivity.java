package com.awesome.retrofitdemo.java.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.awesome.retrofitdemo.R;
import com.awesome.retrofitdemo.java.APIService;
import com.awesome.retrofitdemo.java.Course;
import com.awesome.retrofitdemo.java.Teacher;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

        // 未封装请求 step1:创建Retrofit对象，使用构建者模式设置固定的url前缀，以及基本配置
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.imooc.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 未封装请求 step2:使用retrofit创建这个接口类
        APIService apiService = retrofit.create(APIService.class);
        // 未封装请求 step3:使用接口类获取Call对象
        Call<Teacher> userCall = apiService.getCall("4","10");
        // 未封装请求 step4:获取回调信息
        userCall.enqueue(new Callback<Teacher>() {
            @Override
            public void onResponse(Call<Teacher> call, Response<Teacher> response) {
                List<Course> courses = response.body().getData();
                for (int i = 0; i < courses.size(); i++) {
                    Log.i("Retrofit",courses.get(i).toString());
                }
            }

            @Override
            public void onFailure(Call<Teacher> call, Throwable t) {
                Log.i("Retrofit","onFailure");
            }
        });



    }

}