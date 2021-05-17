package com.awesome.glidedemo;

import android.app.LoaderManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.awesome.glidedemo.pickpicture.BaseActivity;
import com.awesome.glidedemo.pickpicture.IMediaPickStrategy;
import com.awesome.glidedemo.pickpicture.Image;
import com.awesome.glidedemo.pickpicture.LoaderCallback;
import com.awesome.glidedemo.pickpicture.Media;
import com.awesome.glidedemo.pickpicture.MediaPickAll;
import com.awesome.glidedemo.pickpicture.MediaPickImage;
import com.awesome.glidedemo.pickpicture.MediaPickVideo;
import com.awesome.glidedemo.pickpicture.PickPictureAdapter;
import com.awesome.sdk.util.ShowLogUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.awesome.glidedemo.pickpicture.Constant.WRITE_EXTERNAL_CODE;
import static com.awesome.glidedemo.pickpicture.Constant.WRITE_EXTERNAL_PERMISSION;
import static com.awesome.glidedemo.pickpicture.LoaderCallback.LOADER_ID;

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
//        if (TextUtils.equals(type, IMediaPickStrategy.Type.IMAGE.name())) {
//            mMediaPickStrategy = new MediaPickImage();
//        } else if (TextUtils.equals(type, IMediaPickStrategy.Type.VIDEO.name())) {
//            mMediaPickStrategy = new MediaPickVideo();
//        }else if (TextUtils.equals(type, IMediaPickStrategy.Type.ALL.name())) {
//            mMediaPickStrategy = new MediaPickAll();
//        }
        mRecyclerView = findViewById(R.id.rv_pick_picture);
        mTvSelectedCount = findViewById(R.id.tv_selected_count);
        if (!hasPermission(WRITE_EXTERNAL_PERMISSION)) {
            requestPermission(WRITE_EXTERNAL_CODE, WRITE_EXTERNAL_PERMISSION);
            return;
        }
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

        Set<Map.Entry<String, List<Image>>> entries = Media.MEDIA_MAP.entrySet();
        for (Map.Entry<String, List<Image>> entry : entries) {
            if (TextUtils.equals(entry.getKey(),type))
                mPickPictureAdapter.setImages(entry.getValue());
        }

//        LoaderManager loaderManager = getLoaderManager();
//        loaderManager.initLoader(LOADER_ID, null, new LoaderCallback(this, mMediaPickStrategy, new LoaderCallback.IOnImageList() {
//            @Override
//            public void imageList(List<Image> images) {
//                mPickPictureAdapter.setImages(images);
//            }
//        }));
    }
}
