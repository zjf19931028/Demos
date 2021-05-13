package com.awesome.uidemo.activitys.textview;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.awesome.uidemo.R;
import com.awesome.uidemo.pickpicture.BaseActivity;
import com.awesome.uidemo.util.KeyboardUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/7 19:26
 * Description: 聊天输入框
 */
public class InputActivity extends BaseActivity {

    private TextView mTvRecord;
    private LinearLayout mLlOperation;
    private LinearLayout mLlRecord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        mTvRecord = findViewById(R.id.tv_record);
        mLlOperation = findViewById(R.id.ll_operation);
        mLlRecord = findViewById(R.id.ll_record);
        mTvRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (KeyboardUtil.isKeyboardShown(InputActivity.this)) {
                    // 隐藏软键盘
                    KeyboardUtil.hideKeyboard(InputActivity.this);
                }
                mLlRecord.setVisibility(View.VISIBLE);
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mLlOperation.getLayoutParams();
                lp.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                lp.addRule(RelativeLayout.ABOVE,R.id.ll_record);
                mLlOperation.setLayoutParams(lp);
            }
        });

    }

}
