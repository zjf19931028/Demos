package com.awesome.mvpdemo.mvp2;

import androidx.annotation.StringRes;

/**
 * Created by Alice on 2021/4/24
 */
public interface BaseContract {
    interface Model {

    }

    interface View<P extends Presenter> {
        void showLoading();

        void showError(@StringRes int str);

        void setPresenter(P presenter);
    }

    interface Presenter {
        void start();

        void destroy();
    }


} 