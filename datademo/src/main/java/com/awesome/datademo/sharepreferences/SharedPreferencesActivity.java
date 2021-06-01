package com.awesome.datademo.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.awesome.datademo.R;
import com.awesome.sdk.util.ShowLogUtil;

public class SharedPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        // 创建时如果有这个文件，将文件解析存入map对象中。没有则创建文件。
        SharedPreferences sp = getSharedPreferences("aaa", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("NAME","jim");
        editor.commit();

        SharedPreferences sp1 = getSharedPreferences("aaa", Context.MODE_PRIVATE);
        SharedPreferences sp2 = getSharedPreferences("aaa", Context.MODE_PRIVATE);
        SharedPreferences sp3 = getSharedPreferences("aaa", Context.MODE_PRIVATE);
        ShowLogUtil.info("sp1==sp2="+(sp1==sp2));
        ShowLogUtil.info("sp3==sp2="+(sp3==sp2));

        // 写操作有两步，一是写入内存，即map集合。二是写入硬盘文件。
        // 读操作不涉及I/O操作，直接从map集合中获取数据。
        // commit()和apply()区别
        // commit():线程安全，性能慢，一般在当前线程完成写操作。
        // apply():线程不安全，性能高，异步处理I/O操作，把写操作放入SingleThreadExecutor线程池中处理。

    }
}