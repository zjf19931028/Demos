package com.awesome.mvpdemo.mvp1;

import com.awesome.mvpdemo.base.Activity;

/**
 * Created by Alice on 2021/4/24
 * V层持有P层引用，创建P层对象，在P层构造方法中调用V层的设置P层方法
 * 使用子类属性权限为保护类型
 */
// V层的基本实现类，集成基类Activity
public abstract class BaseActivity<P extends BaseContract.Presenter> extends Activity
        implements BaseContract.View<P> {
    // P层对象
    protected P mPresenter;

    @Override
    protected void initBefore() {
    }

    // 通用方法实现
    @Override
    public void showLoading() {

    }

    @Override
    public void showError(int str) {

    }

    // 持有P层引用
    @Override
    public void setPresenter(P presenter) {
        mPresenter = presenter;

    }

    // 实现P层的真实实现类
    protected abstract P initPresenter();

    // 销毁时，调用P层的销毁方法
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.destroy();
    }
}