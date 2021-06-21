package com.awesome.imagedemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.awesome.sdk.util.ShowLogUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

import org.jetbrains.annotations.NotNull;

public class GlideActivity extends AppCompatActivity {
    //    public static final String URL="https://www.shuimuchangxiang.com/appapi/images/personal/bill.png";
    public static final String URL = "http://img.mukewang.com/55249cf30001ae8a06000338-300-170.jpg";

    private ImageView mIvNet;
    private ImageView mIvLocal;
    private ImageView mIvCompress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        mIvNet = findViewById(R.id.iv_net);
        mIvLocal = findViewById(R.id.iv_local);
        mIvCompress = findViewById(R.id.iv_compress);


        /**
         * Glide回调请求
         */
        Glide.with(this)
                .asBitmap()
                .load(URL)
                .centerCrop()
                .into(new CustomTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull @NotNull Bitmap resource, @Nullable @org.jetbrains.annotations.Nullable Transition<? super Bitmap> transition) {
                        ShowLogUtil.info("toTransform.getWidth=" + resource.getWidth());
                        mIvNet.setImageBitmap(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable @org.jetbrains.annotations.Nullable Drawable placeholder) {

                    }
                });

        /**
         * 加载本地图片
         */
        Glide.with(this)
                .asBitmap()
                .load(R.mipmap.bg_src_morning)
                .into(mIvLocal);

        /**
         * 压缩图片
         */
        Glide.with(this)//创建实例
                .load(URL)//各种资源的url
                .placeholder(R.mipmap.ic_launcher)//预加载图片
                .error(R.mipmap.ic_launcher)//访问错误的error返回
                .override(30, 30)//加载图片有内存浪费，压缩
                .fitCenter()//不会填满，会在边界范围之内
                .centerCrop()//会填满，图片显示不完整
                .skipMemoryCache(true)//跳过内存缓存，true不会将图片放到内存缓存
                .diskCacheStrategy(DiskCacheStrategy.ALL)//磁盘缓存
                .priority(Priority.HIGH)
                .into(mIvCompress);


    }
}