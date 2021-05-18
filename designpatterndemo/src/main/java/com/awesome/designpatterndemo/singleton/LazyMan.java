package com.awesome.designpatterndemo.singleton;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/18 17:35
 * Description: 懒汉单例
 * 优点：在使用时才会被实例化（懒加载）
 * 致命缺点：每次调用都需要同步，造成不必要的同步开销
 */
public class LazyMan {
    private static LazyMan instance;

    private LazyMan() {
    }

    public static synchronized LazyMan getInstance(){
        if (instance == null){
            instance = new LazyMan();
        }
        return instance;
    }
}
