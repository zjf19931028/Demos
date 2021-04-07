package com.awesome.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        Fruit();
//        Fruit("violet");
//        Fruit("violet","Grape");
//        Grape("violet")
//        Grape("violet", "Grape")
//        Grape("Shandong");
//        Grape("Shandong","hugePeak");
        super.getDelegate()
        AdvanceLayout(this);
    }

}