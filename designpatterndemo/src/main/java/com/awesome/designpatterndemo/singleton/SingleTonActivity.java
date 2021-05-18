package com.awesome.designpatterndemo.singleton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.awesome.designpatterndemo.R;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/19 15:24
 * Description:
 * 核心：构造函数私有化
 * 静态方法获取唯一实例
 * 这个过程保证线程安全、防止反序列化导致重新生成实例对象
 */
public class SingleTonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_ton);
    }
}