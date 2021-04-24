package com.awesome.mvpdemo.main;

import com.awesome.mvpdemo.mvp1.BaseContract;
import com.awesome.mvpdemo.mvp1.BasePresenter;

/**
 * Created by Alice on 2021/4/24
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter{

    public MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public void calculate(int n) {
        getView().calculateSuccess(n-1);
    }
}