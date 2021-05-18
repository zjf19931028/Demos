package com.awesome.designpatterndemo.singleton;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/18 17:37
 * Description: 静态内部类单例
 * 优点：静态内部类（线程安全、单例唯一、延迟加载）
 * 外部类调用时不会加载内部类，内部类不被加载则不会初始化INSTACE，不会占用内存。只有在调用getInstance()才会初始化Instance.
 * 使用场景：1.配置类的一些参数。如封装Retrofit,创建OkHttpClient单例对象,创建Retrofit单例对象，请求参数对象
 */
public class StaticInnerClass {
    /**
     * 创建一个私有静态内部类
     * 创建一个私有静态最终的实例
     */
    private static class SingleTonHolder{
        private static final StaticInnerClass INSTANCE = new StaticInnerClass();
    }

    /**
     * 对外创建一个方法，获取单例
     * @return
     */
    public static StaticInnerClass getInstance(){
        return SingleTonHolder.INSTANCE;
    }
}
