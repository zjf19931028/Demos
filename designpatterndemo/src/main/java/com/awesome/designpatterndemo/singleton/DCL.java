package com.awesome.designpatterndemo.singleton;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/18 17:36
 * Description: DCL单例
 * 改进点：解决懒汉式每次需要同步，在不为空时直接返回对象，不需要同步。
 * 致命缺点：JVM内存模型实例化对象三步骤：1.为实例分配内存。2.调用构造，初始化成员属性。3.将对象指向分配的内存。
 * 由于是乱序执行，在执行完1，3，实例不为空时，一个线程使用对象，但是并没有初始化数据，这样会报错。
 * 优点：资源利用率高
 * 缺点：高并发场景由于Java内存模型偶尔会失败。
 */
public class DCL {
    private static DCL mInstance;

    private DCL() {
    }

    public static DCL getInstance() {
        if (mInstance == null) {
            synchronized (DCL.class) {
                if (mInstance == null) {
                    mInstance = new DCL();
                }
            }
        }
        return mInstance;
    }
}
