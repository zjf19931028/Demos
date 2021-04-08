package com.awesome.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jeejiouser.qajeejio.com/user/users/judgeIsUserExist")
                .build();
        APIService apiService = retrofit.create(APIService.class);
        Call<String> userCall = apiService.getUser();

    }
}