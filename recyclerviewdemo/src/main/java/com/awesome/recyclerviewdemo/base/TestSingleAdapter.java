package com.awesome.recyclerviewdemo.base;

import android.view.View;

import com.awesome.recyclerviewdemo.R;
import com.awesome.recyclerviewdemo.base.RecyclerAdapter;
import com.awesome.recyclerviewdemo.java.Course;

/**
 * Created by Alice on 2021/4/24
 */
public class TestSingleAdapter extends RecyclerAdapter<Course> {
    @Override
    protected int getItemViewType(int position, Course course) {
        return R.layout.item_course_layout;
    }

    @Override
    protected ViewHolder<Course> onCreateViewHolder(View root, int viewType) {
        return null;
    }

    @Override
    public void update(Course course, ViewHolder<Course> holder) {

    }
}