package com.awesome.demos.test.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * Created by Mjj on 2018/7/29.
 */

public class OneActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建用于封装数据的Bundle对象
        Bundle bundle = new Bundle();
        bundle.putString("name", "Mjj");
        bundle.putInt("age", 18);

        //先查看一下未更改的值
        Toast.makeText(this, "age = " + ApplicationForFiled.age, Toast.LENGTH_SHORT).show();
        ApplicationForFiled.age = 23;

        Intent intent = new Intent(OneActivity.this, SecondActivity.class);
        //将Bundle对象嵌入Intent中
        intent.putExtras(bundle);
        startActivity(intent);


    }
}
