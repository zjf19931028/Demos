package com.awesome.audiorecorddemo.constant;

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
    public static final String[] RECORD_AUDIO_PERMISSION = new String[]{Manifest.permission.RECORD_AUDIO};
    public static final String[] LOCATION_PERMISSION = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};

}
