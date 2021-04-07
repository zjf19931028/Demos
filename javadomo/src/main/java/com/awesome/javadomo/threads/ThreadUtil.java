package com.awesome.javadomo.threads;

import java.util.concurrent.Executors;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/19 11:59
 * Description:
 */
public class ThreadUtil {
    public void thread(){
        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool();
//        Executors.newScheduledThreadPool();
        Executors.newSingleThreadExecutor();
    }
}
