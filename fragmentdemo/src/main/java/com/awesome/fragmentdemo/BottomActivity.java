package com.awesome.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.RadioGroup;

public class BottomActivity extends AppCompatActivity {


    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        // TODO底部导航功能
        mRadioGroup = findViewById(R.id.rg_bottom);

        TitleFragment homeFragment = TitleFragment.newInstance("首页");
        TitleFragment momentsFragment = TitleFragment.newInstance("朋友圈");
        TitleFragment meFragment = TitleFragment.newInstance("我的");

        FragmentManager fm = getSupportFragmentManager();
        // 初始化一个Fragment到视图
        fm.beginTransaction()
                .replace(R.id.ll_container,homeFragment)
                .commit();

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        fm.beginTransaction()
                                .replace(R.id.ll_container,homeFragment)
                                .commit();
                        break;
                    case R.id.rb_moments:
                        fm.beginTransaction()
                                .replace(R.id.ll_container,momentsFragment)
                                .commit();
                        break;
                    case R.id.rb_me:
                        fm.beginTransaction()
                                .replace(R.id.ll_container,meFragment)
                                .commit();
                        break;
                }
            }
        });
    }
}