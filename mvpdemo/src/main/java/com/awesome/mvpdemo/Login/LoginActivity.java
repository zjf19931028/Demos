package com.awesome.mvpdemo.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.awesome.mvpdemo.R;
import com.awesome.mvpdemo.mvp2.BaseActivity;
import com.awesome.mvpdemo.mvp2.BaseContract;
import com.awesome.sdk.util.ToastUtils;

public class LoginActivity extends BaseActivity<LoginContract.Presenter> implements LoginContract.View {

    private TextView mTextView;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initWidget() {
        mTextView = findViewById(R.id.tv_login);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void loginSuccess() {

        ToastUtils.showToast(this,"登录");
    }


    @Override
    protected LoginContract.Presenter initPresenter() {
        return new LoginPresenter(this);
    }
}