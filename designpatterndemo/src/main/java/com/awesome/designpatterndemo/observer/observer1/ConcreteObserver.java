package com.awesome.designpatterndemo.observer.observer1;


import com.awesome.sdk.util.ShowLogUtil;

/**
 * Created by Alice on 2019/9/19
 *
 * @function
 */
public class ConcreteObserver implements Observer {
    //观察者状态
    private String observerState;

    @Override
    public void update(String state) {
        observerState = state;
        ShowLogUtil.info("ConcreteObserver state:" + observerState);
    }
}
