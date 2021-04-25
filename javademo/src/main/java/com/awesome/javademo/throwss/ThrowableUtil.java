package com.awesome.javademo.throwss;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/19 09:29
 * Description:
 */
public class ThrowableUtil {
    public static void throwable() throws Error{
        Throwable t1 = new Error();
        Throwable t2 = new Exception();
        Throwable t3 = new RuntimeException();
        Throwable t4 = new IndexOutOfBoundsException();
        Throwable t5 = new NullPointerException();
        Throwable t6 = new ClassCastException();
        throw new Error();
    }
}
