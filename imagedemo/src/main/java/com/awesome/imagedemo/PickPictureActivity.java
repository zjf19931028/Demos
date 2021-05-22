package com.awesome.imagedemo;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.awesome.imagedemo.strategy.IMediaPickStrategy;
import com.awesome.imagedemo.bean.Image;
import com.awesome.imagedemo.callback.LoaderCallback;
import com.awesome.imagedemo.bean.Album;
import com.awesome.imagedemo.strategy.MediaPickAll;
import com.awesome.imagedemo.strategy.MediaPickImage;
import com.awesome.imagedemo.strategy.MediaPickVideo;
import com.awesome.imagedemo.adpter.PickPictureAdapter;
import com.awesome.sdk.base.BaseActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.awesome.imagedemo.callback.LoaderCallback.LOADER_ID;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/7 14:07
 * Description: 选择照片
 */
public class PickPictureActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private TextView mTvSelectedCount;
    private PickPictureAdapter mPickPictureAdapter;
    private List<Image> mSelectedImages = new LinkedList<>();
    private IMediaPickStrategy mMediaPickStrategy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_picture);
        String type = getIntent().getStringExtra("Type");
        if (TextUtils.equals(type, IMediaPickStrategy.Type.IMAGE.name())) {
            mMediaPickStrategy = new MediaPickImage();
        } else if (TextUtils.equals(type, IMediaPickStrategy.Type.VIDEO.name())) {
            mMediaPickStrategy = new MediaPickVideo();
        } else if (TextUtils.equals(type, IMediaPickStrategy.Type.ALL.name())) {
            mMediaPickStrategy = new MediaPickAll();
        }

        mRecyclerView = findViewById(R.id.rv_pick_picture);
        mTvSelectedCount = findViewById(R.id.tv_selected_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.top = 20;
                outRect.left = 20;
                outRect.bottom = 20;
            }
        });
        mPickPictureAdapter = new PickPictureAdapter(this, mSelectedImages);
        mRecyclerView.setAdapter(mPickPictureAdapter);
        mPickPictureAdapter.setSelectedCountChanged(new PickPictureAdapter.SelectedChangeListener() {
            @Override
            public void onSelectedCountChanged(int count) {
                mTvSelectedCount.setText("已选" + count + "张");
            }
        });

        // 获取当前相册的图片
//        Set<Map.Entry<String, List<Image>>> entries = Album.MEDIA_MAP.entrySet();
//        for (Map.Entry<String, List<Image>> entry : entries) {
//            if (TextUtils.equals(entry.getKey(),type))
//                mPickPictureAdapter.setImages(entry.getValue());
//        }

        // 获取手机系统资源
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, new LoaderCallback(this, mMediaPickStrategy, new LoaderCallback.IOnImageList() {
            @Override
            public void imageList(List<Image> images) {
                mPickPictureAdapter.setImages(images);
            }
        }));
    }
}
