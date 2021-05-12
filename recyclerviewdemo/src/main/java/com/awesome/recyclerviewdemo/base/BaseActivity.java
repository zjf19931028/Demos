package com.awesome.recyclerviewdemo.base;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.awesome.recyclerviewdemo.R;
import com.awesome.recyclerviewdemo.SingleCourseAdapter;
import com.awesome.recyclerviewdemo.itemdecoration.StickyItemDecoration;
import com.awesome.recyclerviewdemo.net.Course;
import com.awesome.recyclerviewdemo.net.Teacher;
import com.awesome.sdk.net.RxClient;
import com.awesome.sdk.util.ShowLogUtil;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BaseActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private List<Course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        mRecyclerView = findViewById(R.id.recycleView);
        initListener();
        initData();
    }

    private void initListener() {

    }

    private void initData() {
        // 线性管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        // 自定义粘性ItemDecoration
        StickyItemDecoration stickyItemDecoration = new StickyItemDecoration() {
            @Override
            public String getName(int position) {
                if (position % 5 == 0) {
                    return "K";
                } else {
                    return "M";
                }
            }
        };
        stickyItemDecoration.setHeight(100);
        mRecyclerView.addItemDecoration(stickyItemDecoration);

        // 单布局
        mAdapter = new MyAdapter(courses,new RecyclerAdapter.AdapterListener(){

            @Override
            public void onItemClick(RecyclerAdapter.ViewHolder holder, Object o) {

            }

            @Override
            public void onItemLongClick(RecyclerAdapter.ViewHolder holder, Object o) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);
        getRequest();
    }

    /**
     * 网络请求
     */
    private void getRequest() {
        ShowLogUtil.info("getRequest");
        WeakHashMap<String, Object> params = new WeakHashMap<>();
        params.put("type", 2);
        params.put("num", 10);
        RxClient.builder()
                .url("api/teacher")
                .params(params)
                .build()
                .get()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onCompleted() {
                        ShowLogUtil.info("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        ShowLogUtil.info("onError");
                    }

                    @Override
                    public void onNext(Object o) {
                        Gson gson = new Gson();
                        String s = gson.toJson(o);
                        Teacher teacher = gson.fromJson(s, Teacher.class);
                        courses.addAll(teacher.getData());
                        mAdapter.notifyDataSetChanged();
                        for (int i = 0; i < teacher.getData().size(); i++) {
                            Log.i("onNext", teacher.getData().get(i).toString());
                        }
                    }
                });
    }
}