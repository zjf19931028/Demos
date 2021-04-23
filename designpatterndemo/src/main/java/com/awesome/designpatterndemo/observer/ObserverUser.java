package com.awesome.designpatterndemo.observer;

import com.awesome.designpatterndemo.observer.observer1.ConcreteObserver;
import com.awesome.designpatterndemo.observer.observer1.ConcreteSubject;
import com.awesome.designpatterndemo.observer.observer1.Observer;
import com.awesome.designpatterndemo.observer.observer2.TargetObservable;
import com.awesome.designpatterndemo.observer.observer2.TargetObserver;
import com.awesome.designpatterndemo.observer.observer3.Employee;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/23 17:54
 * Description:
 */
public class ObserverUser {
    public static void observer1() {
        //        //创建目标对象
//        ConcreteSubject concreteSubject=new ConcreteSubject();
//        //创建观察者对象
//        Observer observer=new ConcreteObserver();
//        //将观察者对象注册到目标对象上
//        concreteSubject.attach(observer);
//        //改变目标对象到状态
//        concreteSubject.change("I change");

        //创建目标对象
        ConcreteSubject concreteSubject = new ConcreteSubject();
        //创建观察者对象
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        //将观察者对象注册到目标对象上
        concreteSubject.attach(observer1);
        concreteSubject.attach(observer2);
        //改变目标对象到状态
        concreteSubject.setState("I change");
        //通知并更新观察者对象
        concreteSubject.notifyObservers(concreteSubject.getState());
    }

    public static void observer2() {
        //创建被观察者对象
        TargetObservable targetObservable = new TargetObservable();
        //创建观察者对象1
        TargetObserver observer1 = new TargetObserver();
        //创建观察者对象2
        TargetObserver observer2 = new TargetObserver();
        //将观察者对象1和被观察者进行关联
        targetObservable.addObserver(observer1);
        //将观察者对象2和被观察者进行关联
        targetObservable.addObserver(observer2);
        //改变被观察者的数据，并通知观察者数据改变
        targetObservable.setMessage("数据改变");
    }

    public static void observer3() {
        Employee employee = new Employee();
        employee.setCallback(new Employee.Callback() {
            @Override
            public void work() {
                System.out.println("TAG "+ "setCallback");
            }
        });
        employee.doWork();
    }
}
