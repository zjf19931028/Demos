package com.awesome.glidedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class MainActivity extends AppCompatActivity {
//    public static final String URL="https://www.shuimuchangxiang.com/appapi/images/personal/bill.png";
    public static final String URL="http://img.mukewang.com/55249cf30001ae8a06000338-300-170.jpg";
    private ImageView mIvNet;
    private ImageView mIvLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIvNet = findViewById(R.id.iv_net);
        mIvLocal = findViewById(R.id.iv_local);

        Glide.with(this)
                .load(URL)
                .centerCrop()
                .into(mIvNet);

        Glide.with(this)//创建实例
                .load(URL)//各种资源的url
                .placeholder(R.mipmap.ic_launcher)//预加载图片
                .error(R.mipmap.ic_launcher)//访问错误的error返回
                .override(30,30)//加载图片有内存浪费，压缩
                .fitCenter()//不会填满，会在边界范围之内
                .centerCrop()//会填满，图片显示不完整
                .skipMemoryCache(true)//跳过内存缓存，true不会将图片放到内存缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE)//磁盘缓存
                .priority(Priority.HIGH)
                .into(mIvLocal);

    }
}