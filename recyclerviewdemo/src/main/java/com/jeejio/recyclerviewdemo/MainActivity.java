package com.jeejio.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import com.jeejio.recyclerviewdemo.java.Course;
import com.jeejio.recyclerviewdemo.java.NetUtil;
import com.jeejio.recyclerviewdemo.java.Teacher;

import java.util.List;

import rx.Observer;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycleView);
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
        NetUtil.get(new Observer<Teacher>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Teacher teacher) {
                List<Course> courses = teacher.getData();
                // 单布局
//                CourseAdapter adapter=new CourseAdapter(courses);
//                mRecyclerView.setAdapter(adapter);

                // 多布局
//                MultiCourseAdapter adapter=new MultiCourseAdapter(new ArrayList<>());
                MultiCourseAdapter adapter=new MultiCourseAdapter(courses);
                mRecyclerView.setAdapter(adapter);
//                for (int i = 0; i < courses.size(); i++) {
//                    Log.i("Retrofit", courses.get(i).toString());
//                }
            }
        });
    }
}