package com.awesome.designpatterndemo.observer.observer1;

import com.awesome.sdk.util.ShowLogUtil;

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
        ShowLogUtil.info(" ConcreteSubject state:" + subjectState);
        //状态发生改变，通知观察者
        notifyObservers(subjectState);
    }
}
