package com.awesome.designpatterndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.awesome.designpatterndemo.observer.ObserverUser;
import com.awesome.designpatterndemo.observer.observer1.ConcreteObserver;
import com.awesome.designpatterndemo.observer.observer1.ConcreteSubject;
import com.awesome.designpatterndemo.observer.observer1.Observer;
import com.awesome.designpatterndemo.observer.observer2.TargetObservable;
import com.awesome.designpatterndemo.observer.observer2.TargetObserver;
import com.awesome.designpatterndemo.observer.observer3.Employee;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObserverUser.observer1();
    }
}