package com.awesome.demos;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/13 17:46
 * Description:
 */
public class MyLifeCycleObserver implements LifecycleObserver {
    private static final String TAG="MyLifeCycleObserver";

    public MyLifeCycleObserver() {

    }
//    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
//    public void onActivityAny(){
//        Log.d(TAG,"onActivityAny");
//    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onActivityCreate(){
        Log.d(TAG,"onActivityCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onActivityStart(){
        Log.d(TAG,"onActivityStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onActivityResume(){
        Log.d(TAG,"onActivityResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onActivityPause(){
        Log.d(TAG,"onActivityPause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onActivityStop(){
        Log.d(TAG,"onActivityStop");
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestory(){
        Log.d(TAG,"onActivityDestory");
    }


}
