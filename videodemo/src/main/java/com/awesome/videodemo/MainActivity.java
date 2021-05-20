package com.awesome.videodemo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;

import com.awesome.sdk.base.BaseActivity;
import com.awesome.sdk.constant.Constant;
import com.awesome.sdk.util.ShowLogUtil;

import java.io.File;
import java.io.IOException;

public class MainActivity extends BaseActivity {


    private File mFile;
    private MediaPlayer mMediaPlayer;
    private RelativeLayout mRlContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!hasPermission(Constant.WRITE_EXTERNAL_PERMISSION)) {
            requestPermission(Constant.WRITE_EXTERNAL_CODE, Constant.WRITE_EXTERNAL_PERMISSION);
        }
        mFile = new File("/storage/emulated/0/Pictures/WeiXin/1602175832362.mp4");
        doIntent();
        doVideoViewMediaController();
        doSurfaceMediaPlayer();
    }

    private void doIntent() {
        findViewById(R.id.btn_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    Uri uri = FileProvider.getUriForFile(MainActivity.this, getPackageName() + ".fileprovider", mFile);
                    intent.setDataAndType(uri, "video/*");
                } else {
                    intent.setDataAndType(Uri.fromFile(mFile), "video/*");
                }
                startActivity(intent);
            }
        });
    }

    private void doVideoViewMediaController() {
        VideoView videoView = findViewById(R.id.video_view);
        MediaController mediaController = new MediaController(this);
        videoView.setVideoPath(mFile.getAbsolutePath());
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    private void doSurfaceMediaPlayer() {
        SurfaceView surfaceView = findViewById(R.id.surface_view);
        mRlContainer = findViewById(R.id.rl_container);
        mMediaPlayer = new MediaPlayer();
        try {
            mMediaPlayer.setDataSource(mFile.getAbsolutePath());
            mMediaPlayer.prepareAsync();
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayer.start();
                }
            });
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    ShowLogUtil.info("onCompletion");
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                mMediaPlayer.setDisplay(holder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mMediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
            @Override
            public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mRlContainer.getLayoutParams();
                lp.height = (int) (mRlContainer.getWidth() * 1.0f / width * height);
                ShowLogUtil.info("lp.height=" + lp.height);
                mRlContainer.setLayoutParams(lp);
            }
        });
    }
}