package com.awesome.javademo.threads;

import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: zhangjingfang
 * Email:zhangjingfang@jeejio.com
 * Date: 2021/6/22 11:08 下午
 * Description:类描述
 */
public class CompareThread {
    public static void compareAsync(){
        ShowLogUtil.info("start");
        MyThread mThread1=new MyThread();
        MyThread mThread2=new MyThread();
        MyThread mThread3=new MyThread();
        MyThread mThread4=new MyThread();
        MyThread mThread5=new MyThread();
        MyThread mThread6=new MyThread();
        MyThread mThread7=new MyThread();
        MyThread mThread8=new MyThread();
        MyThread mThread9=new MyThread();
        MyThread mThread10=new MyThread();
        MyThread mThread11=new MyThread();
        MyThread mThread12=new MyThread();
        mThread1.start();
        mThread2.start();
        mThread3.start();
        mThread4.start();
        mThread5.start();
        mThread6.start();
        mThread7.start();
        mThread8.start();
        mThread9.start();
        mThread10.start();
        mThread11.start();
        mThread12.start();
    }
    public static void compareSync(){
        ShowLogUtil.info("start");
        MyThread mThread1=new MyThread();
        MyThread mThread2=new MyThread();
        mThread1.start();
        mThread1.setListener(new MyThread.OnListener() {
            @Override
            public void onComplete() {
                mThread2.start();
            }
        });
    }

} 