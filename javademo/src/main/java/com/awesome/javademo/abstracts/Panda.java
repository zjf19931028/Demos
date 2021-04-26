package com.awesome.javademo.abstracts;


import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/19 09:52
 * Description:
 */
public class Panda extends Animal{
    public void eat() {
        ShowLogUtil.info("熊猫吃竹子");
    }

    public void activity(){
        ShowLogUtil.info("熊猫卖萌");
    }
}
