package com.awesome.arouterdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/16 16:18
 * Description:
 */
@Route(path = Constance.ACTIVITY_URL_SECOND,group = Constance.GROUP_FIRST)
public class SecondActivity extends BaseActivity {

    @Autowired(name = "name")
    String mName;
    @Autowired(name = "flag")
    boolean mFlag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ShowLogUtil.info("mName="+mName);
        ShowLogUtil.info("mFlag="+mFlag);
        findViewById(R.id.tv_return).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("greet","hi~");
                setResult(123,intent);
                finish();
            }
        });
        findViewById(R.id.tv_jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build(Constance.ACTIVITY_URL_THIRD)
                        .navigation();
            }
        });
    }
}
