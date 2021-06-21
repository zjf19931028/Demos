package com.awesome.imagedemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ImageWriter;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.awesome.imagedemo.strategy.IMediaPickStrategy;
import com.awesome.sdk.base.BaseActivity;
import com.awesome.sdk.util.ShowLogUtil;

import static com.awesome.sdk.constant.Constant.WRITE_EXTERNAL_CODE;
import static com.awesome.sdk.constant.Constant.WRITE_EXTERNAL_PERMISSION;

/**
 * 遗留问题：
 * 1.LoaderCallback查询不同列以及解析不同列
 */

public class MainActivity extends BaseActivity {
    //    public static final String URL="https://www.shuimuchangxiang.com/appapi/images/personal/bill.png";
    public static final String URL = "http://img.mukewang.com/55249cf30001ae8a06000338-300-170.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!hasPermission(WRITE_EXTERNAL_PERMISSION)) {
            requestPermission(WRITE_EXTERNAL_CODE, WRITE_EXTERNAL_PERMISSION);
        }

        findViewById(R.id.tv_bitmap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BitmapActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_glide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GlideActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_select_one_picture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PickOneActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_select_picture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PickPictureActivity.class);
                intent.putExtra("Type", IMediaPickStrategy.Type.IMAGE.name());
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_select_video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PickPictureActivity.class);
                intent.putExtra("Type", IMediaPickStrategy.Type.VIDEO.name());
                startActivity(intent);
            }
        });

        findViewById(R.id.tv_select_picture_or_video).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PickPictureActivity.class);
                intent.putExtra("Type", IMediaPickStrategy.Type.ALL.name());
                startActivity(intent);
            }
        });

//        // 构建相册的数据
//        LoaderManager loaderManager = getLoaderManager();
//        loaderManager.initLoader(LOADER_ID, null, new LoaderCallback(this, new MediaPickImage(), new LoaderCallback.IOnImageList() {
//            @Override
//            public void imageList(List<Image> images) {
//                for (Image image : images) {
//                    if (Media.MEDIA_MAP.containsKey(image.bucketDisplayName)) {
//                        Media.MEDIA_MAP.get(image.bucketDisplayName).add(image);
//                    } else {
//                        List<Image> imageList = new ArrayList<>();
//                        imageList.add(image);
//                        Media.MEDIA_MAP.put(image.bucketDisplayName, imageList);
//                    }
//                }
//                Set<Map.Entry<String, List<Image>>> entries = Media.MEDIA_MAP.entrySet();
//                for (Map.Entry<String, List<Image>> entry : entries) {
//                    ShowLogUtil.info("key=" + entry.getKey() + ",value=" + entry.getValue().size());
//                    TextView textView = new TextView(MainActivity.this);
//                    textView.setText("" + entry.getKey());
//                    textView.setPadding(20, 100, 20, 100);
//                    textView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
////                            for (int i = 0; i < entry.getValue().size(); i++) {
////                                Image image = entry.getValue().get(i);
////                                ShowLogUtil.info("path=" + image.path);
////                            }
////                            Intent intent = new Intent(MainActivity.this, PickPictureActivity.class);
////                            intent.putExtra("Type", entry.getKey());
////                            startActivity(intent);
//                        }
//                    });
//                    llAlbum.addView(textView);
//                }
//            }
//        }));
//        media.MEDIA_MAP.put(111, new ArrayList<>());
//        loaderManager.initLoader(LOADER_ID, null, new LoaderCallback(this, new MediaPickVideo(), new LoaderCallback.IOnImageList() {
//            @Override
//            public void imageList(List<Image> images) {
//                for (Image image : images) {
//                    media.MEDIA_MAP.get(111).add(image);
//                }
//                for (int i = 0; i < media.MEDIA_MAP.get(111).size(); i++) {
//                    Image image = media.MEDIA_MAP.get(111).get(i);
////                    ShowLogUtil.info("path=" + image.path);
//                }
//
//            }
//        }));


    }
}