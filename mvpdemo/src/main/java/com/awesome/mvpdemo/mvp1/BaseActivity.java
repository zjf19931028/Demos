package com.awesome.mvpdemo.mvp1;

import com.awesome.mvpdemo.base.Activity;

/**
 * Created by Alice on 2021/4/24
 * V层持有P层引用，创建P层对象，在P层构造方法中调用V层的设置P层方法
 * 使用子类属性权限为保护类型
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.destroy();
    }
}