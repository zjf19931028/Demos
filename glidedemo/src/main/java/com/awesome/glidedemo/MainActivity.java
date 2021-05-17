package com.awesome.glidedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LoaderManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.awesome.glidedemo.pickpicture.IMediaPickStrategy;
import com.awesome.glidedemo.pickpicture.Image;
import com.awesome.glidedemo.pickpicture.LoaderCallback;
import com.awesome.glidedemo.pickpicture.Media;
import com.awesome.glidedemo.pickpicture.MediaPickAll;
import com.awesome.glidedemo.pickpicture.MediaPickImage;
import com.awesome.glidedemo.pickpicture.MediaPickVideo;
import com.awesome.sdk.util.ShowLogUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.awesome.glidedemo.pickpicture.LoaderCallback.LOADER_ID;

public class MainActivity extends AppCompatActivity {
    //    public static final String URL="https://www.shuimuchangxiang.com/appapi/images/personal/bill.png";
    public static final String URL = "http://img.mukewang.com/55249cf30001ae8a06000338-300-170.jpg";
    private ImageView mIvNet;
    private ImageView mIvLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIvNet = findViewById(R.id.iv_net);
        mIvLocal = findViewById(R.id.iv_local);
        LinearLayout llAlbum = findViewById(R.id.ll_album);

        Glide.with(this)
                .load(URL)
                .centerCrop()
                .into(mIvNet);

        Glide.with(this)//创建实例
                .load(URL)//各种资源的url
                .placeholder(R.mipmap.ic_launcher)//预加载图片
                .error(R.mipmap.ic_launcher)//访问错误的error返回
                .override(30, 30)//加载图片有内存浪费，压缩
                .fitCenter()//不会填满，会在边界范围之内
                .centerCrop()//会填满，图片显示不完整
                .skipMemoryCache(true)//跳过内存缓存，true不会将图片放到内存缓存
                .diskCacheStrategy(DiskCacheStrategy.NONE)//磁盘缓存
                .priority(Priority.HIGH)
                .into(mIvLocal);

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