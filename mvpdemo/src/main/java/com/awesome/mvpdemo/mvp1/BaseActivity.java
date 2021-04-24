package com.awesome.mvpdemo.mvp1;

import com.awesome.mvpdemo.base.Activity;

/**
 * Created by Alice on 2021/4/24
 */
public abstract class BaseActivity<P extends BaseContract.Presenter> extends Activity
        implements BaseContract.View<P> {
    protected P mPresenter;

    @Override
    protected void initBefore() {
        initPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(int str) {

    }

    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;

    }

    protected abstract P initPresenter();

}