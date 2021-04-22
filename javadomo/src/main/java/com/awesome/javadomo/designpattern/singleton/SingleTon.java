package com.awesome.javadomo.designpattern.singleton;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/19 15:24
 * Description: 静态内部类（线程安全、单例唯一、延迟加载）
 * 外部类调用时不会加载内部类，内部类不被加载则不会初始化INSTACE，不会占用内存。只有在调用getInstance()才会初始化Instance.
 */
public class SingleTon {
    private static class SingleTonHolder{
        public static final SingleTon INSTANCE = new SingleTon();
    }
    public SingleTon getInstance(){
        return SingleTonHolder.INSTANCE;
    }
}
