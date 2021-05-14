package com.awesome.filedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.awesome.sdk.base.BaseActivity;
import com.cocav.tiemu.utils.AmrEncoder;
import com.cocav.tiemu.utils.opus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static com.awesome.sdk.constant.Constant.RECORD_AUDIO_CODE;
import static com.awesome.sdk.constant.Constant.RECORD_AUDIO_PERMISSION;
import static com.awesome.sdk.constant.Constant.WRITE_EXTERNAL_CODE;
import static com.awesome.sdk.constant.Constant.WRITE_EXTERNAL_PERMISSION;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!hasPermission(RECORD_AUDIO_PERMISSION)) {
            requestPermission(RECORD_AUDIO_CODE, RECORD_AUDIO_PERMISSION);
        }
        if (!hasPermission(WRITE_EXTERNAL_PERMISSION)) {
            requestPermission(WRITE_EXTERNAL_CODE, WRITE_EXTERNAL_PERMISSION);
        }
        findViewById(R.id.tv_recoed).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN:
                        Log.i("recordaaa", "ACTION_DOWN");
                        try {

                            OutputStream outputStream = new FileOutputStream(getAudioTmpFile(false));

                            AmrEncoder.getInstance().start(new AmrEncoder.Callback() {
                                @Override
                                public void onEncoded(byte[] buffer, long millsec, int dbs)  {
                                    try {
                                        outputStream.write(buffer, 0, buffer.length);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    Log.i("recordaaa", "audioTmpFile.length()=" + getAudioTmpFile(false).length());
//                                    Log.i("recordaaa", "buffer.toString()=" + buffer.toString());
                                }

                                @Override
                                public void onEnd() {
                                    Log.i("recordaaa", "onEnd");
                                    try {
                                        outputStream.close();
                                        Log.i("recordaaa", "audioTmpFile.length()=" + getAudioTmpFile(false).length());
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                }
                            });
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("recordaaa", "ACTION_UP");
                        AmrEncoder.getInstance().stop();
                        break;

                }
                return true;
            }
        });
    }

    /**
     * Author: JfangZ
     * Email:zhangjingfang@jeejio.com
     * Date: 2021/2/4 14:52
     * Description: 获取录音的本地文件路径
     *
     * @param isTmp 是否是缓存文件， True，每次返回的文件地址是一样的
     * @return 录音文件的地址
     */
    public static File getAudioTmpFile(boolean isTmp) {
        File dir = new File(getCacheDirFile(), "audio");
        dir.mkdirs();
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                file.delete();
            }
        }
        File path = new File(getCacheDirFile(), isTmp ? "tmp.mp3" : SystemClock.uptimeMillis() + ".mp3");
        return path.getAbsoluteFile();
    }

    /**
     * 字节流的写入
     */
    public static void byteWrite(File file, byte[] buffer) {
        try {
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(buffer, 0, buffer.length);
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取缓存文件夹地址
     *
     * @return 当前APP的缓存文件夹地址
     */
    public static File getCacheDirFile() {
        return App.getInstance().getCacheDir();
    }

}