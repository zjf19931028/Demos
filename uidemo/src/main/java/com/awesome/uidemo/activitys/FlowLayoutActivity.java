package com.awesome.uidemo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.awesome.uidemo.R;
import com.awesome.uidemo.customview.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class FlowLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_layout);
        //        CustomFlowLayout mCustomFlowLayout = findViewById(R.id.custom_scroll_view);
//        mCustomFlowLayout.setOnClickListener(new View.OnClickListener() {
//                                           @Override
//                                           public void onClick(View v) {
//
//                                           }
//                                       }
//        );

        LinearLayout mLinearLayout = findViewById(R.id.ll_flow_layout);
        FlowLayout mFlowLayout = findViewById(R.id.flow_layout);
        FlowLayout mFlowLayout2 = findViewById(R.id.flow_layout2);
        mFlowLayout2.setMaxLine(1);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 10, 20, 10);
        List<String> keywords = new ArrayList<>();
        keywords.add("1keywordskeywordskeyword");
        keywords.add("2keywordskeywordskeyword");
        keywords.add("3keywordskeywordskeywordskeywordskeywordskeywords");
        keywords.add("4keywordskeywordskeywordskeywordskeywordskeywords");
        keywords.add("5keywordskeywordskeywordskeywordskeywordskeywords");
        keywords.add("6keywordskeywordskeywordskeywordskeywordskeywords");
        keywords.add("7keywordskeywordskeywordskeywordskeywordskeywords");
        keywords.add("8keywordskeywordskeywordskeywordskeywordskeywords");
        if (mFlowLayout != null) {
            mFlowLayout.removeAllViews();
        }
        if (mFlowLayout2 != null) {
            mFlowLayout2.removeAllViews();
        }
        if (keywords != null && keywords.size() > 0) {
            for (String keyword : keywords) {
                TextView textView=new TextView(this);
                textView.setBackgroundColor(Color.WHITE);
                textView.setLayoutParams(lp);
                textView.setText(keyword);
                textView.setTextColor(Color.YELLOW);
                mFlowLayout.addView(textView);
            }
        }
        if (keywords != null && keywords.size() > 0) {
            for (String keyword : keywords) {
                TextView textView=new TextView(this);
                textView.setBackgroundColor(Color.WHITE);
                textView.setLayoutParams(lp);
                textView.setText(keyword);
                textView.setTextColor(Color.YELLOW);
                mFlowLayout2.addView(textView);
            }
        }

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    mLinearLayout.setVisibility(View.VISIBLE);
                    mFlowLayout2.setVisibility(View.GONE);
                }else {
                    mLinearLayout.setVisibility(View.GONE);
                    mFlowLayout2.setVisibility(View.VISIBLE);
                }
                flag = !flag;
            }
        });
    }
    boolean flag = true;
}