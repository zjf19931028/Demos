package com.awesome.javademo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.awesome.javademo.R;
import com.awesome.javademo.abstracts.AbstractAnimal;
import com.awesome.javademo.abstracts.Animal;
import com.awesome.javademo.abstracts.Panda;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AbstractAnimal abstractAnimal = new Animal();//向上转型，调用子类的重写方法，或父类未被重写的方法
        abstractAnimal.eat();
        Animal a = (Animal) abstractAnimal;// 向下转型，可以调用子类的重写方法，和子类独有的方法。即子类的全部方法。
        a.eat();
        a.sleep();
    }
}