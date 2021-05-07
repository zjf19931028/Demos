package com.awesome.uidemo.activitys;

import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;

import com.awesome.sdk.util.ShowLogUtil;
import com.awesome.uidemo.pickpicture.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/7 18:24
 * Description:
 */
public class LoaderCallback implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int MIN_IMAGE_FILE_SIZE = 10 * 1024; // 最小的图片大小
    public static final int LOADER_ID = 0x0100;

    private Context mContext;
    private IOnImageList mIOnImageList;

    public LoaderCallback(Context context, IOnImageList IOnImageList) {
        mContext = context;
        mIOnImageList = IOnImageList;
    }

    private final String[] IMAGE_PROJECTION = new String[]{
            MediaStore.Images.Media._ID, // Id
            MediaStore.Images.Media.DATA, // 图片路径
            MediaStore.Images.Media.DATE_ADDED // 图片的创建时间ø
    };

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // 创建一个Loader
        if (id == LOADER_ID) {
            // 如果是我们的ID则可以进行初始化
            return new CursorLoader(mContext,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    IMAGE_PROJECTION,
                    null,
                    null,
                    null); // 倒序查询
        }
        return null;
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {
        // 当Loader加载完成时
        List<Image> images = new ArrayList<>();
        // 判断是否有数据
        if (data != null) {
            int count = data.getCount();
            ShowLogUtil.info("count="+count);
            if (count > 0) {
                // 移动游标到开始
                data.moveToFirst();

                // 得到对应的列的Index坐标
                int indexId = data.getColumnIndexOrThrow(IMAGE_PROJECTION[0]);
                int indexPath = data.getColumnIndexOrThrow(IMAGE_PROJECTION[1]);
                int indexDate = data.getColumnIndexOrThrow(IMAGE_PROJECTION[2]);
                do {
                    // 循环读取，直到没有下一条数据
                    int id = data.getInt(indexId);
                    String path = data.getString(indexPath);
                    long dateTime = data.getLong(indexDate);

                    File file = new File(path);
                    if (!file.exists() || file.length() < MIN_IMAGE_FILE_SIZE) {
                        // 如果没有图片，或者图片大小太小，则跳过
                        continue;
                    }


                    // 添加一条新的数据
                    Image image = new Image();
                    image.id = id;
                    image.path = path;
                    image.date = dateTime;
                    ShowLogUtil.info(image.toString());
                    images.add(image);


                } while (data.moveToNext());
            }
        }
        mIOnImageList.imageList(images);
    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
        // 当Loader销毁或者重置了, 进行界面清空
        mIOnImageList.imageList(new ArrayList<>());
    }

    public interface IOnImageList{
        void imageList(List<Image> images);
    }
}

