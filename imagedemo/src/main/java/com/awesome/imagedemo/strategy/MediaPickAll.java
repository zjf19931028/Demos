package com.awesome.imagedemo.strategy;

import android.net.Uri;
import android.provider.MediaStore;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/17 16:28
 * Description:
 */
public class MediaPickAll implements IMediaPickStrategy {
    @Override
    public Uri getUri() {
        return MediaStore.Files.getContentUri("external");
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
                MediaStore.Images.Media.ALBUM // 相册名称;
        };
    }

    @Override
    public String getSelection() {
        return "("
                + MediaStore.Files.FileColumns.MEDIA_TYPE + "=" + MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE
                + " OR "
                + MediaStore.Files.FileColumns.MEDIA_TYPE + "=" + MediaStore.Files.FileColumns.MEDIA_TYPE_VIDEO
                + ")"
                + " AND "
                // 所有图片和 mp4 格式的视频
                + "("
                + MediaStore.Files.FileColumns.MIME_TYPE + " LIKE 'image/%'"
                + " OR "
                + MediaStore.Files.FileColumns.MIME_TYPE + "='video/mp4'"
                + ")"
                + " AND "
                // 文件大小需要大于 0
                + MediaStore.Files.FileColumns.SIZE + ">0"
                + " AND "
                // 如果是 mp4 的话,视频时长需大于 0
                + "("
                + MediaStore.Files.FileColumns.MIME_TYPE + "!='video/mp4'"
                + " OR "
                + "("
                + MediaStore.Files.FileColumns.MIME_TYPE + "='video/mp4' AND duration>0"
                + ")"
                + ")";
    }
}
