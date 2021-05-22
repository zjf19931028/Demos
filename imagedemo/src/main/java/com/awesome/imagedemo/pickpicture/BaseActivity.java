package com.awesome.imagedemo.pickpicture;

import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.awesome.sdk.BaseApplication;

import static com.awesome.imagedemo.pickpicture.Constant.CAMERA_CODE;
import static com.awesome.imagedemo.pickpicture.Constant.LOCATION_CODE;
import static com.awesome.imagedemo.pickpicture.Constant.RECORD_AUDIO_CODE;
import static com.awesome.imagedemo.pickpicture.Constant.WRITE_EXTERNAL_CODE;


/**
 * Author: JfangZ
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/1/29 16:38
 * Description:
 */
public class BaseActivity extends AppCompatActivity {

    public boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(BaseApplication.getInstance().getApplicationContext(), permission) != PackageManager.PERMISSION_GRANTED) {
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
            case LOCATION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    doLocation();
                break;
            case CAMERA_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    doCamera();
                break;
            case WRITE_EXTERNAL_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    doWrite();
                break;
            default:
                break;
        }
    }

    public void doRecord() {
    }

    public void doLocation() {
    }

    public void doCamera() {
    }

    public void doWrite() {
    }
}
