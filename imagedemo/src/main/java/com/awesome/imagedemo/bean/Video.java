package com.awesome.imagedemo.bean;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/22 09:51
 * Description:
 */
public class Video extends BaseImage{
    public long duration; // 文件时长

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
