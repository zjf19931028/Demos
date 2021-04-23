package com.awesome.designpatterndemo.observer.observer2;

import com.awesome.sdk.util.ShowLogUtil;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Alice on 2019/9/19
 *
 * @function
 */
//Observer对象是观察者，实现Observer的对象就是具体的观察者对象
public class TargetObserver implements Observer {
    //定义观察者名字
    private String name;

    public String getObserverName(){
        return this.name;
    }

    public void setObserverName(String observerName){
        this.name=observerName;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.name=((TargetObservable)o).getContent();
        //更新消息数据
        ShowLogUtil.info(" 收到了发生变化的数据内容是："+ this.name);
    }
}
