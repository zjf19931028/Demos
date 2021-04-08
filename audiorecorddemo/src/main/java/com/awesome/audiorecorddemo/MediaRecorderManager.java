package com.awesome.audiorecorddemo;

import android.media.MediaRecorder;
import android.os.Handler;

import com.awesome.audiorecorddemo.io.EncryptUtil;
import com.awesome.audiorecorddemo.io.FilePathUtil;

import java.io.File;
import java.io.IOException;

/**
 * Author: JfangZ
 * Email:zhangjin
 * gfang@jeejio.com
 * Date: 2021/2/4 14:26
 * Description: 录音管理类
 */
public enum MediaRecorderManager {
    SINGLETON;
    public static final int MAX_LENGTH = 1000 * 60;
    private MediaRecorder mMediaRecorder;
    private IOnMediaRecordListener mListener;
    private File mOriginalFile;
    private Handler mHandler;

    MediaRecorderManager() {
        mHandler = new Handler();
    }

    /**
     * Author: JfangZ
     * Email:zhangjingfang@jeejio.com
     * Date: 2021/2/4 15:23
     * Description: 开始录音
     */
    public void startRecord(IOnMediaRecordListener listener) {
        if (mMediaRecorder == null)
            mMediaRecorder = new MediaRecorder();
        mListener = listener;
        try {
            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            String mOriginalFilePath = FilePathUtil.getMediaRecorderLocalPath();
            mOriginalFile = new File(mOriginalFilePath);
            if (!mOriginalFile.exists()) mOriginalFile.getParentFile().mkdirs();
            mOriginalFile.createNewFile();
            mMediaRecorder.setOutputFile(mOriginalFilePath);
            mMediaRecorder.setMaxDuration(MAX_LENGTH);
            mMediaRecorder.prepare();
            mMediaRecorder.start();
            if (mListener != null)
                mListener.onStart();
        } catch (IOException e) {
            e.printStackTrace();
            if (mListener != null)
                mListener.onError(e);
        }
    }

    /**
     * Author: JfangZ
     * Email:zhangjingfang@jeejio.com
     * Date: 2021/2/4 15:25
     * Description: 停止录音
     */
    public void stopRecord() {
        if (mMediaRecorder != null) {
            try {
                mMediaRecorder.stop();
                mMediaRecorder.reset();
                mMediaRecorder.release();
                mMediaRecorder = null;
                if (mListener != null)
                    mListener.onStop();
                String encryptFilePath = FilePathUtil.getMediaRecorderEncryptLocalPath();
                File encryptFile = new File(encryptFilePath);
                if (!encryptFile.exists()) encryptFile.getParentFile().mkdirs();
                encryptFile.createNewFile();
                // 密钥
                String aesSecret = EncryptUtil.generateAesSecret();
                // 加密录音文件
                EncryptUtil.encryptFile(mOriginalFile, encryptFile, aesSecret);
                // 解密
                EncryptUtil.decryptFile(encryptFile, aesSecret);
            } catch (Exception e) {
                mMediaRecorder.reset();
                mMediaRecorder.release();
                mMediaRecorder = null;
                if (mListener != null)
                    mListener.onError(e);
            }

        }
    }

    public interface IOnMediaRecordListener {
        void onStart();

        void onStop();

        void onError(Exception e);

        void onVolumeChange(int curVolume);
    }

    private class CurVolumeRunnable implements Runnable {

        @Override
        public void run() {
            if (mMediaRecorder == null || mListener == null) return;
            int maxAmplitude = mMediaRecorder.getMaxAmplitude();
            mListener.onVolumeChange(maxAmplitude);

            // 每隔 100ms 获取一次
            mHandler.postDelayed(this,100);
        }
    }
}
