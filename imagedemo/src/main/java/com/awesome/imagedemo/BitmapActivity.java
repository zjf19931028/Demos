package com.awesome.imagedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class BitmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.bg_src_morning);
        ((ImageView)findViewById(R.id.iv_local)).setImageBitmap(bitmap2);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.bg_src_morning, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        String iamgeType = options.outMimeType;
//        ShowLogUtil.info("imageHeight=" + imageHeight);
//        ShowLogUtil.info("imageWidth=" + imageWidth);
//        ShowLogUtil.info("iamgeType=" + iamgeType);

        int inSampleSize = 1;
        if (imageHeight > 100 || imageWidth > 100) {
            int heightRatio = Math.round(imageHeight / 100);
            int widthRatio = Math.round(imageWidth / 100);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        options.inSampleSize = inSampleSize;
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bg_src_morning,options);
        ((ImageView)findViewById(R.id.iv_compress)).setImageBitmap(bitmap);
    }
}