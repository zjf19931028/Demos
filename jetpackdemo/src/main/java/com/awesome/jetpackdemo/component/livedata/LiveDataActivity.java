package com.awesome.jetpackdemo.component.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.awesome.jetpackdemo.R;

import org.jetbrains.annotations.Nullable;

public class LiveDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data_activity);
        Button btn = findViewById(R.id.btn);
        //构建ViewModel对象
        final SimpleViewModel model = ViewModelProviders.of(this).get(SimpleViewModel.class);

        //监听content属性变化，只要触发了setValue/postValue方法就会走
        model.getContent().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.e("SimpleActivity", "onChanged");
                btn.setText(s);
            }
        });

        //起始点
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发起获取数据
                model.getContentData();
            }
        });
    }
}