package com.awesome.mvpdemo.Login;

import androidx.annotation.StringRes;

import com.awesome.mvpdemo.mvp2.BaseContract;

/**
 * Created by Alice on 2021/4/24
 */
public interface LoginContract {
    interface Model {

    }

    interface View extends BaseContract.View<Presenter> {
        void loginSuccess();
    }

    interface Presenter extends BaseContract.Presenter {
        void login();
    }
} 