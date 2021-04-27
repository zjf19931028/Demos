package com.awesome.retrofitdemo.test;

import com.awesome.retrofitdemo.encapsulation.RetrofitCreator;
import com.awesome.retrofitdemo.encapsulation.RetrofitRequest;
import com.awesome.retrofitdemo.encapsulation.listener.DisposeDataListener;

import java.util.WeakHashMap;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/27 15:14
 * Description:
 */
public class Network<T> {
    public void getList(String page, String pageNum, DisposeDataListener<T> listener) {
        WeakHashMap<String, Object> params = new WeakHashMap<>();
        params.put("type", page);
        params.put("num", pageNum);
        new RetrofitRequest<T>("api/teacher",params).request(listener);
    }

    public void getInfoRx(Observer<T> observer) {
        Observable observable = RetrofitCreator.getService().getInfoRx("4", "10");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
