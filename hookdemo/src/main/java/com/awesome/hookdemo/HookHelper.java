package com.awesome.hookdemo;

import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/21 15:17
 * Description:
 */
public class HookHelper {
    public static void hookOnClickListener(View view) throws Exception {
        // 反射得到ListenerInfo对象
        Method getListenerInfo = View.class.getDeclaredMethod("getListenerInfo");
        getListenerInfo.setAccessible(true);
        Object listenerInfo = getListenerInfo.invoke(view);
        // 得到原始OnClickListener事件方法
        Class<?> listenerInfoClz = Class.forName("android.view.View$ListenerInfo");
        Field mListenerInfo = listenerInfoClz.getDeclaredField("mListenerInfo");
        mListenerInfo.setAccessible(true);
        View.OnClickListener originOnClickListener = (View.OnClickListener) mListenerInfo.get(listenerInfo);
        // 用Hook代理类 替换原始OnClickListener
        View.OnClickListener hookedClickListener = new HookedClickListenerProxy(originOnClickListener);
        mListenerInfo.set(listenerInfo,hookedClickListener);
    }
}
