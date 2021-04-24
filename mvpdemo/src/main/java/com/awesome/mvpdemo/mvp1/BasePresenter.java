package com.awesome.mvpdemo.mvp1;

/**
 * Created by Alice on 2021/4/24
 */
public class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {
    private V mView;

    public BasePresenter(V view) {
        setView(view);
    }

    protected final V getView() {
        return mView;
    }

    public void setView(V view) {
        mView = view;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        if (mView != null) {
            mView.setPresenter(null);
        }
        mView = null;

    }
}