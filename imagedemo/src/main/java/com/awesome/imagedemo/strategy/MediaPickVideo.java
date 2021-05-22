package com.awesome.imagedemo.strategy;

import android.net.Uri;
import android.provider.MediaStore;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/17 16:15
 * Description:
 */
public class MediaPickVideo implements IMediaPickStrategy {
    @Override
    public Uri getUri() {
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    @Override
    public String[] getProjection() {
        return new String[]{
                MediaStore.Images.Media._ID, // Id
                MediaStore.Images.Media.DATA, // 图片路径
                MediaStore.Images.Media.DATE_ADDED, // 图片的创建时间
                MediaStore.Files.FileColumns.MIME_TYPE, // 文件类型
                MediaStore.Files.FileColumns.DURATION, // 文件时长
                MediaStore.Images.Media.BUCKET_ID, // 相册Id
                MediaStore.Images.Media.ALBUM // 相册名称
        };
    }

    @Override
    public String getSelection() {
        return null;
    }
}
