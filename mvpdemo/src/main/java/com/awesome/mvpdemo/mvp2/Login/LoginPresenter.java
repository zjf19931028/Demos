package com.awesome.mvpdemo.mvp2.Login;

import com.awesome.mvpdemo.mvp2.BasePresenter;

/**
 * Created by Alice on 2021/4/24
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void login() {
        getView().loginSuccess();

    }
}