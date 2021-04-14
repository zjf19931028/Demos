package com.jeejio.recyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.jeejio.recyclerviewdemo.java.Course;
import com.jeejio.recyclerviewdemo.java.NetUtil;
import com.jeejio.recyclerviewdemo.java.Teacher;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Course> courses;
    private SmartRefreshLayout mSmartRefreshLayout;
    //    private MultiCourseAdapter mAdapter;
    private CourseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycleView);
        mSmartRefreshLayout = findViewById(R.id.smartRefreshLayout);
        initListener();
        initData();
    }

    private void initListener() {
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }

    private void initData() {
        // 线性管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // 网格管理器
//        GridLayoutManager layoutManager = new GridLayoutManager(this,5);
        // 瀑布流管理器
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        // 自定义ItemDecoration
        mRecyclerView.addItemDecoration(new DividerItemDecoration.Builder().setPaintColor(Color.RED)
                .setDividerMarginLeft(40).setViewMarginTop(40).setViewMarginBottom(40).build());
        // 单布局
        mAdapter = new CourseAdapter(courses);
        mRecyclerView.setAdapter(mAdapter);

        // 多布局
//        mAdapter = new MultiCourseAdapter(new ArrayList<>());
//        mAdapter = new MultiCourseAdapter(courses);
//        mRecyclerView.setAdapter(mAdapter);
        NetUtil.get(new Observer<Teacher>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Teacher teacher) {
                courses = teacher.getData();
                mAdapter.notifyDataSetChanged();
                for (int i = 0; i < courses.size(); i++) {
                    Log.i("Retrofit", courses.get(i).toString());
                }
            }
        });
    }
}