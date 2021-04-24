package com.awesome.mvpdemo.mvp2;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Alice on 2021/4/24
 * 持有View的引用为弱引用
 */
public class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {
    private Reference<V> mViewReference;

    public BasePresenter(V view) {
        setView(view);
    }

    public V getView() {
        return mViewReference.get();
    }

    public void setView(V view) {
        mViewReference = new WeakReference<>(view);
        // V层获取P层的引用
        mViewReference.get().setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        if (mViewReference != null) {
            mViewReference.clear();
            mViewReference = null;
        }
    }
}