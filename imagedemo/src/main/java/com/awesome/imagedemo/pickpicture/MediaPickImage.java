package com.awesome.imagedemo.pickpicture;

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
    public String getSelection() {
        return null;
    }
}
