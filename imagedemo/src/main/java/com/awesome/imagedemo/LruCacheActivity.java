package com.awesome.imagedemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.LruCache;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.awesome.imagedemo.R;

/**
 * Created by Alice on 2021/5/28
 */
public class LruCacheActivity extends AppCompatActivity {

    private LruCache<String, Bitmap> mLruCache;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lru_cache);

        int maxMeory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMeory / 8;
        mLruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };

    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapToMemoryCache(key) == null) {
            mLruCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapToMemoryCache(String key) {
        return mLruCache.get(key);

    }
}