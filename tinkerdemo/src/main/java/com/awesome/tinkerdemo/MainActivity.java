package com.awesome.tinkerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.awesome.sdk.base.BaseActivity;
import com.awesome.sdk.constant.Constant;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void loadApk(View view) {
        if(!hasPermission(Constant.WRITE_EXTERNAL_PERMISSION)) {
            requestPermission(Constant.WRITE_EXTERNAL_CODE,Constant.WRITE_EXTERNAL_PERMISSION);
        }else {
            PluginManager.getInstance().setContext(this);
            PluginManager.getInstance().loadApk(Environment.getExternalStorageDirectory().getAbsolutePath()+"/otherapk-debug.apk");
        }

    }

    public void startApk(View view) {
        Intent intent = new Intent(this, ProxyActivity.class);
        String otherApkMainActivityName = PluginManager.getInstance().getPluginPackageArchiveInfo().activities[0].name;
        intent.putExtra("className", otherApkMainActivityName);
        startActivity(intent);
    }
}