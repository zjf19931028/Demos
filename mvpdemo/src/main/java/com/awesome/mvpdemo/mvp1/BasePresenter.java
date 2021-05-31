package com.awesome.mvpdemo.mvp1;

/**
 * Created by Alice on 2021/4/24
 * P层持有V层引用，创建V层对象，在构造中赋值
 * 使用get方法获取属性
 */
// P层的基本实现类
public class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {
    // V层对象
    private V mView;

    // 持有V层引用
    public BasePresenter(V view) {
        setView(view);
    }

    protected final V getView() {
        return mView;
    }

    // 持有V层引用同时，让V层持有P层引用
    public void setView(V view) {
        mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    // 释放V层持有的P层引用
    @Override
    public void destroy() {
        if (mView != null) {
            mView.setPresenter(null);
        }
        mView = null;

    }
}