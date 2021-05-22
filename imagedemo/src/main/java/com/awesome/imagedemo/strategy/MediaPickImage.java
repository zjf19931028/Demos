package com.awesome.imagedemo.strategy;

import android.net.Uri;
import android.provider.MediaStore;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/17 16:14
 * Description:
 */
public class MediaPickImage implements IMediaPickStrategy {
    @Override
    public Uri getUri() {
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    @Override
    public String[] getProjection() {
        return new String[]{
                MediaStore.Images.Media._ID, // Id
                MediaStore.Images.Media.DATA, // 图片路径
                MediaStore.Images.Media.DATE_ADDED, // 图片的创建时间
        };
    }

    @Override
    public String getSelection() {
        return null;
    }
}
