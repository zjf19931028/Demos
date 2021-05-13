package com.awesome.glidedemo.pickpicture;

import android.Manifest;

/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/2/3 19:50
 * Description: 常量
 */
public class Constant {
    public static final int RECORD_AUDIO_CODE = 0x01;
    public static final int LOCATION_CODE = 0x02;
    public static final int CAMERA_CODE = 0x03;
    public static final int WRITE_EXTERNAL_CODE = 0x04;
    public static final String[] RECORD_AUDIO_PERMISSION = new String[]{Manifest.permission.RECORD_AUDIO};
    public static final String[] LOCATION_PERMISSION = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
    public static final String[] CAMERA_PERMISSION = new String[]{Manifest.permission.CAMERA};
    public static final String[] WRITE_EXTERNAL_PERMISSION = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

}
