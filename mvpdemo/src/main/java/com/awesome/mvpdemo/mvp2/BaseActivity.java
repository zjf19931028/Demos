package com.awesome.mvpdemo.mvp2;

import com.awesome.mvpdemo.base.Activity;

/**
 * Created by Alice on 2021/4/24
 * 在创建P层时，View中赋值Presenter
 */
public abstract class BaseActivity<P extends BaseContract.Presenter> extends Activity implements BaseContract.View<P> {

    protected P mPresenter;

    @Override
    protected void initBefore() {
        initPresenter();
    }

    protected abstract P initPresenter();

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.destroy();
    }
}