package com.awesome.recyclerviewdemo.base;

import android.view.View;

import com.awesome.recyclerviewdemo.R;
import com.awesome.recyclerviewdemo.net.Course;
import com.awesome.sdk.util.ShowLogUtil;

import java.util.List;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/12 17:49
 * Description:
 */
public class MyAdapter extends RecyclerAdapter<Course>{
    public MyAdapter(List<Course> courses, AdapterListener<Course> listener) {
        super(courses, listener);
    }

    @Override
    protected int getItemViewType(int position, Course course) {
        return R.layout.item_course_layout;
    }

    @Override
    protected ViewHolder<Course> onCreateViewHolder(View root, int viewType) {
        ShowLogUtil.info("onCreateViewHolder");
        return new MyHolder(root);
    }

    @Override
    public void update(Course course, ViewHolder<Course> holder) {

    }
}
