package com.awesome.glidedemo;

import android.app.LoaderManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.awesome.glidedemo.pickpicture.BaseActivity;
import com.awesome.glidedemo.pickpicture.Image;
import com.awesome.glidedemo.pickpicture.LoaderCallback;
import com.awesome.glidedemo.pickpicture.PickPictureAdapter;
import com.awesome.sdk.util.ShowLogUtil;
import java.util.ArrayList;
import java.util.List;
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
    private PickPictureAdapter mPickPictureAdapter;
    private List<Image> mImages = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_picture);
        mRecyclerView = findViewById(R.id.rv_pick_picture);
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
                outRect.bottom = 20;
            }
        });
        mPickPictureAdapter = new PickPictureAdapter(this, mImages);
        mRecyclerView.setAdapter(mPickPictureAdapter);
        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(LOADER_ID, null, new LoaderCallback(this, new LoaderCallback.IOnImageList() {
            @Override
            public void imageList(List<Image> images) {
                mPickPictureAdapter.setImages(images);
            }
        }));
    }
}
