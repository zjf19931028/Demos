package com.awesome.javademo.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/3/19 11:59
 * Description:
 */
public class ThreadUtil {
    public void thread() {
        Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool();
//        Executors.newScheduledThreadPool();
        Executors.newSingleThreadExecutor();
    }

    public static ScheduledExecutorService scheduledThreadPool() {
        System.out.println("ThreadUtil scheduledThreadPool");
        final ScheduledExecutorService sThreadPool = Executors.newScheduledThreadPool(1);
        sThreadPool.scheduleAtFixedRate(new Runnable() {
            int i = 1;

            @Override
            public void run() {
                if (i >= 3) {
                    sThreadPool.shutdown();
                    System.out.println("ThreadUtil shutdown" + i);
                    return;
                }
                System.out.println("ThreadUtil newScheduledThreadPool" + i);
                i++;
            }
        }, 1, 3, TimeUnit.SECONDS);
        return sThreadPool;
    }

    public static ScheduledExecutorService singleThreadScheduledExecutor() {
        System.out.println("ThreadUtil singleThreadScheduledExecutor");
        ScheduledExecutorService sThreadPool = Executors.newSingleThreadScheduledExecutor();
        sThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadUtil newSingleThreadScheduledExecutor");
            }
        }, 1, 3, TimeUnit.SECONDS);
        return sThreadPool;
    }
}
