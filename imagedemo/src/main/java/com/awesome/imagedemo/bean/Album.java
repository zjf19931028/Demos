package com.awesome.imagedemo.bean;

import android.util.ArrayMap;

import com.awesome.imagedemo.bean.Image;

import java.util.List;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/17 15:15
 * Description:
 */
public class Album {
    public static final ArrayMap<String, List<Image>> MEDIA_MAP = new ArrayMap<>();


    public static class Bean {
        // 相册名字
        String name;
        // 路径
        String path;
    }
}
