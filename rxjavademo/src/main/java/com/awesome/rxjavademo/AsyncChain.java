package com.awesome.rxjavademo;


import com.awesome.sdk.util.ShowLogUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/8 13:49
 * Description:
 */
public class AsyncChain {
    public static void asyncChain(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("连载1");
                e.onNext("连载2");
                e.onNext("连载3");
                e.onComplete();
            }
        })
        .observeOn(AndroidSchedulers.mainThread())//回调在主线程
        .subscribeOn(Schedulers.io())//执行在主线程，也可以用Schedules.newThread()，io可以重用空闲线程，小路更高
        .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                ShowLogUtil.info("onSubscribe");
            }

            @Override
            public void onNext(String value) {
                ShowLogUtil.info("onNext:"+value);
            }

            @Override
            public void onError(Throwable e) {
                ShowLogUtil.info("onError");
            }

            @Override
            public void onComplete() {
                ShowLogUtil.info("onComplete");
            }
        });
    }
}
