package com.awesome.audiorecorddemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.app.Application;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.awesome.audiorecorddemo.app.App;
import com.awesome.audiorecorddemo.util.ShowLogUtil;

import java.io.File;

import static com.awesome.audiorecorddemo.constant.Constant.RECORD_AUDIO_CODE;
import static com.awesome.audiorecorddemo.constant.Constant.RECORD_AUDIO_PERMISSION;

public class AudioRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_record);
        if (!hasPermission(RECORD_AUDIO_PERMISSION)) {
            requestPermission(RECORD_AUDIO_CODE, RECORD_AUDIO_PERMISSION);
        }
        AudioRecordView audioRecordView = findViewById(R.id.view_audio_record);
        File tmpFile = App.getAudioTmpFile(true);

        AudioRecordHelper helper = new AudioRecordHelper(tmpFile, new AudioRecordHelper.RecordCallback() {
            @Override
            public void onRecordStart() {
                Log.i("jlog", "onRecordStart");
            }

            @Override
            public void onProgress(long time) {
//                Log.i("jlog", "onProgress,time=" + time);

            }

            @Override
            public void onRecordDone(File file, long time) {
                Log.i("jlog", "onRecordDone,file=" + file.getAbsolutePath() + ",time=" + time);
            }
        });
        audioRecordView.setup(new AudioRecordView.Callback() {
            @Override
            public void requestStartRecord() {
                Log.i("jlog", "requestStartRecord");
                helper.recordAsync();
            }

            @Override
            public void requestStopRecord(int type) {
                Log.i("jlog", "requestStopRecord,type=" + type);
                // 请求结束
                switch (type) {
                    case AudioRecordView.END_TYPE_CANCEL:
                    case AudioRecordView.END_TYPE_DELETE:
                        // 删除和取消都代表想要取消
                        helper.stop(true);
                        break;
                    case AudioRecordView.END_TYPE_NONE:
                        // 播放暂时当中就是想要发送
                        helper.stop(false);
                        break;
                }
            }
        });
    }

    public boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(App.getInstance().getApplicationContext(), permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }


    public void requestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case RECORD_AUDIO_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    doRecord();
                break;
        }
    }

    private void doRecord() {
    }
}