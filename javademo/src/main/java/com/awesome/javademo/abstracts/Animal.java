package com.awesome.javademo.abstracts;


import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/19 10:11
 * Description:
 */
public class Animal extends AbstractAnimal{
    private String color;
    public  void eat(){
        ShowLogUtil.info("动物吃饭");
    }

    public  void sleep(){
        ShowLogUtil.info("动物睡觉");
    }
}
