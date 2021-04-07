package com.awesome.javadomo.annotation;


/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/26 15:29
 * Description:
 */
public class SayHello {
    @HelloWorld(name = "Jane")
    public void sayHello() {
//        ShowLogUtil.info(  " say hello");
    }

    @HelloWorld(name = "John")
    public void bye(int age) {
//        ShowLogUtil.info( age+" years old");
    }
}
