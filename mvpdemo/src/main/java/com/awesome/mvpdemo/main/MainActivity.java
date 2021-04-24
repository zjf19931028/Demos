package com.awesome.mvpdemo.main;


import android.view.View;
import android.widget.TextView;

import com.awesome.mvpdemo.R;
import com.awesome.mvpdemo.mvp1.BaseActivity;
import com.awesome.sdk.util.ToastUtils;

public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {

    private TextView mTextView;

    @Override
    protected MainContract.Presenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        mTextView = findViewById(R.id.tv);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.calculate(2);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void calculateSuccess(int returnN) {
        mTextView.setText("" + returnN);
    }
}