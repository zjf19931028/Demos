package com.awesome.designpatterndemo.observer.observer3;


/**
 * Created by Alice on 2019/9/25
 *
 * @function
 */
public class Employee {
    //定义回调接口的成员变量
    private Callback mCallback;

    //声明回调接口
    public interface Callback {
       void work();
    }

    //设置回调接口对象成员变量
    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    //调用回调接口对象中的方法
    public void doWork() {
        mCallback.work();
    }

}
