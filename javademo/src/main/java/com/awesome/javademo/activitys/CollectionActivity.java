package com.awesome.javademo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.awesome.javademo.R;
import com.awesome.javademo.collection.ArrayListTest;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        ArrayListTest.getArrayList();
    }
}