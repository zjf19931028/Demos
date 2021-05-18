package com.awesome.designpatterndemo.singleton;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/18 17:37
 * Description:最好的单例
 * 反序列化时将单例的实例对象写到磁盘，再读回来，创建新的对象。类中有一个钩子函数readResolve()，返回实例对象。
 */
public enum Enum {
    INSTANCE;
}
