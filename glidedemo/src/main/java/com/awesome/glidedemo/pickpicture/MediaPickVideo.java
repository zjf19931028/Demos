package com.awesome.glidedemo.pickpicture;

import android.net.Uri;
import android.provider.MediaStore;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/17 16:15
 * Description:
 */
public class MediaPickVideo implements IMediaPickStrategy{
    @Override
    public Uri getUri() {
        return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    @Override
    public String getSelection() {
        return null;
    }
}
