package com.awesome.rxjavademo;

import android.text.TextUtils;

import com.awesome.sdk.util.ShowLogUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/8 13:48
 * Description:
 */
public class Operator {
    private static Disposable mDisposable;

    public static void operator(){
        // 观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
                ShowLogUtil.info("onSubscribe");
            }

            @Override
            public void onNext(String value) {
                if (TextUtils.equals(value,"from操作符创建观察者2"))
                    mDisposable.dispose();
                ShowLogUtil.info("onNext:" + value);
            }

            @Override
            public void onError(Throwable e) {
                ShowLogUtil.info("onError");
            }

            @Override
            public void onComplete() {
                ShowLogUtil.info("onComplete");
            }
        };
        // 被观察者
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("hello world");
                e.onComplete();
            }
        });
        observable.subscribe(observer);

        // create操作符，创建被观察者，复写方法中有一个观察者参数
        Observable<String> observableCreate = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("create操作符创建被观察者");
                e.onComplete();
            }
        });
        observableCreate.subscribe(observer);

        // just操作符,接收一个对象转化为被观察者
        Observable<String> observableJust = Observable.just("just操作符创建观察者");
        observableJust.subscribe(observer);

        // fromArray操作符,接收多个对象转化为被观察者,顺序发给观察者
        Observable<String> observableFromArray = Observable.fromArray("from操作符创建观察者1", "from操作符创建观察者2", "from操作符创建观察者3");
        observableFromArray.subscribe(observer);

        // flatMap操作符

        // Map操作符

        // filter操作符

        // take操作符

        // doNext操作符
    }
}
