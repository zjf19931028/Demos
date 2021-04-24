package com.awesome.playerdemo;

import android.media.MediaPlayer;
import android.os.Environment;

import com.awesome.sdk.util.ShowLogUtil;

import java.io.File;
import java.io.IOException;

/**
 * Created by Alice on 2021/3/24
 */
public enum MyMediaPlayer {
    SINGLETON;
    private MediaPlayer mMediaPlayer;
    MyMediaPlayer() {
        try {
            // 空闲状态
            mMediaPlayer = new MediaPlayer();
            // 初始化状态
            mMediaPlayer.setDataSource(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "a.mp3");
            // 准备状态
           mMediaPlayer.prepare();
            ShowLogUtil.info("prepare");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 播放音乐
    public void startMusic(){
        if (!mMediaPlayer.isPlaying()){
            ShowLogUtil.info("startMusic");
            mMediaPlayer.start();
        }
    }

    //暂停音乐
    public void pauseMusic(){
        if (mMediaPlayer.isPlaying()){
            ShowLogUtil.info("pauseMusic");
            mMediaPlayer.pause();
        }

    }
}