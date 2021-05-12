package com.awesome.recyclerviewdemo;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awesome.recyclerviewdemo.net.Course;
import com.awesome.sdk.util.ShowLogUtil;

import java.util.List;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/14 15:55
 * Description: 单布局适配器
 */
public class SingleCourseAdapter extends RecyclerView.Adapter<SingleCourseAdapter.ViewHolder> {
    private List<Course> mCourseList;

    public SingleCourseAdapter(List<Course> courseList) {
        mCourseList = courseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ShowLogUtil.info("onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShowLogUtil.info("onBindViewHolder");
        Course course = mCourseList.get(position);
        holder.mTextView.setText(course.getName());
        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        ShowLogUtil.info("getItemCount");
        if (mCourseList == null) return 0;
        return mCourseList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_course);
            mTextView = itemView.findViewById(R.id.tv_course);
        }
    }
}
