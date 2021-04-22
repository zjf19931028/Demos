package com.awesome.javadomo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alice on 2019/9/19
 *
 * @function 抽象目标者
 */
public abstract class Subject {
    //保存注册的观察者对象
    private List<Observer> mObservers = new ArrayList<>();

    //注册观察者对象
    public void attach(Observer observer) {
        mObservers.add(observer);
        System.out.println("TAG"+ " Attached an observer");
    }

    //注销观察者对象
    public void detach(Observer observer) {
        mObservers.remove(observer);
        System.out.println("TAG"+" Detach an observer");
    }

    //通知所有注册的观察者对象
    public void notifyObservers(String newState) {
        for (Observer observer : mObservers) {
            observer.update(newState);
        }
    }
}
