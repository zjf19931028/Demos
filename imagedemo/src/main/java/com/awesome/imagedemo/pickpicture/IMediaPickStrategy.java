package com.awesome.imagedemo.pickpicture;

import android.net.Uri;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/17 16:14
 * Description:
 */
public interface IMediaPickStrategy {
    enum Type{
        IMAGE,
        VIDEO,
        ALL;
    }
    Uri getUri();
    String getSelection();
}
