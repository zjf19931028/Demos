package com.awesome.javadomo.designpattern.observer;

/**
 * Created by Alice on 2019/9/19
 *
 * @function
 */
public class ConcreteSubject extends Subject {
    private String subjectState;

    public String getState() {
        return subjectState;
    }

    public void setState(String state) {
        this.subjectState = state;
    }

    public void change(String newState) {
        subjectState = newState;
        System.out.println("TAG" + " ConcreteSubject state:" + subjectState);
        //状态发生改变，通知观察者
        notifyObservers(subjectState);
    }
}
