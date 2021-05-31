package com.awesome.mvpdemo.mvp1;

import androidx.annotation.StringRes;

/**
 * Created by Alice on 2021/4/24
 */

//建立约束接口
public interface BaseContract {
    // V层约束接口
    interface View<P extends Presenter> {
        // 通用方法
        void showLoading();

        void showError(@StringRes int str);

        // 设置与与P层关联，需要P泛型
        void setPresenter(P presenter);
    }
    // P层约束接口
    interface Presenter {
        void start();

        void destroy();

    }
} 