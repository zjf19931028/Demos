package com.awesome.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.awesome.sdk.util.ShowLogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowLogUtil.info("MainActivity onCreate ");
        // 跳转切换视图
        findViewById(R.id.btn_switch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BottomActivity.class));
            }
        });

        // 在容器中添加、替换、移除Fragment
        LifeCycleFragment listFragment = new LifeCycleFragment();
        TitleFragment detailFragment = new TitleFragment();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.ll_list_container,listFragment)
                .commit();
        // add为叠加效果，可以通过remove移除
        // replace为替换原则
        fm.beginTransaction()
                .replace(R.id.ll_detail_container,detailFragment)
                .commit();
//        fm.beginTransaction()
//                .replace(R.id.ll_list_container,detailFragment)
//                .commit();
//        fm.beginTransaction()
//                .remove(detailFragment)
//                .commit();
    }


    @Override
    public void onStart() {
        super.onStart();
        ShowLogUtil.info("MainActivity onStart ");
    }

    @Override
    public void onResume() {
        super.onResume();
        ShowLogUtil.info("MainActivity onResume ");
    }

    @Override
    public void onPause() {
        super.onPause();
        ShowLogUtil.info("MainActivity onPause ");
    }

    @Override
    public void onStop() {
        super.onStop();
        ShowLogUtil.info("MainActivity onStop ");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        ShowLogUtil.info("MainActivity onDestroy ");
    }

}