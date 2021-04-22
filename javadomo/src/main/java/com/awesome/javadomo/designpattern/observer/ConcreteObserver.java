package com.awesome.javadomo.designpattern.observer;


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
        System.out.println("TAG" + " ConcreteObserver state:" + observerState);
    }
}
