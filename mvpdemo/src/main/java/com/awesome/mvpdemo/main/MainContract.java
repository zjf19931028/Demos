package com.awesome.mvpdemo.main;

import com.awesome.mvpdemo.mvp1.BaseContract;

/**
 * Created by Alice on 2021/4/24
 */
public interface MainContract {
    interface View extends BaseContract.View<Presenter>{
        void calculateSuccess(int returnN);

    }
    interface Presenter extends BaseContract.Presenter{
        void calculate(int n);

    }
} 