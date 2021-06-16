package com.awesome.arouterdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.awesome.sdk.util.ShowLogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // build第一个参数跳转uri，第二个参数分组
                // withString传参
                // navigation第二个参数带返回Intent，第三个参数拦截回调
                ARouter.getInstance()
                        .build(Constance.ACTIVITY_URL_SECOND, Constance.GROUP_FIRST)
                        .withString("name", "android")
                        .withBoolean("flag", true)
                        .navigation(MainActivity.this, 123, new NavCallback() {
                            // 拦截处理之前的方法
                            @Override
                            public void onFound(Postcard postcard) {
                                super.onFound(postcard);
                                ShowLogUtil.info("onFound:getGroup:" + postcard.getGroup() + ",getPath:" + postcard.getPath());
                            }

                            // 拦截处理之后的方法
                            @Override
                            public void onArrival(Postcard postcard) {
                                ShowLogUtil.info("onArrival:getGroup:" + postcard.getGroup() + ",getPath:" + postcard.getPath());
                            }
                        });

            }
        });
        findViewById(R.id.tv_jump_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build(Constance.ACTIVITY_URL_MY)
                        .navigation();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            ShowLogUtil.info("onActivityResult");
            if (data != null)
                ShowLogUtil.info(data.getStringExtra("greet"));
        }
    }
}