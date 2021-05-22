package com.awesome.imagedemo.pickpicture;

import android.util.ArrayMap;

import java.util.List;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/17 15:15
 * Description:
 */
public class Media {
    public static final ArrayMap<String, List<Image>> MEDIA_MAP = new ArrayMap<>();


    public static class Bean {
        // 相册名字
        String albumName;
        // 路径
        String path;
    }
}
