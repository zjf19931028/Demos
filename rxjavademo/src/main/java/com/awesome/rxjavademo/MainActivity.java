package com.awesome.rxjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.awesome.sdk.util.ShowLogUtil;


import java.util.Optional;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity {
    Disposable disposable;  //   全局变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Operator.operator();
//        AsyncChain.asyncChain();
        testCount();
    }

    void testCount() {
        disposable = Observable.intervalRange(0,10,1, 1, TimeUnit.SECONDS)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        Log.d("rxjava11", "apply aLong: " + aLong);
                        return aLong + 5;
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long count) throws Exception {
                        Log.d("rxjava11", "accept count: " + count);
//                        if (count == 10) {
//                            if (disposable != null) {
//                                disposable.dispose();
//                            }
//                        }
                    }
                });
    }

    void stop() {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}