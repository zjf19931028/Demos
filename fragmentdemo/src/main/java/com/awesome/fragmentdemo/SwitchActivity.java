package com.awesome.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.awesome.sdk.util.ShowLogUtil;

public class SwitchActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        RadioGroup radioGroup = findViewById(R.id.rg_bottom);
        DetailFragment homeFragment = DetailFragment.newInstance("首页");
        DetailFragment momentsFragment = DetailFragment.newInstance("朋友圈");
        DetailFragment meFragment = DetailFragment.newInstance("我的");
        FragmentManager fm = getSupportFragmentManager();
        // 初始化一个Fragment到视图
        fm.beginTransaction()
                .replace(R.id.ll_container,homeFragment)
                .commit();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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