package com.awesome.recyclerviewdemo.base;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.awesome.recyclerviewdemo.R;
import com.awesome.recyclerviewdemo.net.Course;
import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/12 17:52
 * Description:
 */
public class MyHolder extends RecyclerAdapter.ViewHolder<Course>{

    private TextView mTextView;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.tv_course);
    }

    @Override
    protected void onBind(Course course) {
        ShowLogUtil.info("onBind");
        mTextView.setText(course.getName());
    }
}
