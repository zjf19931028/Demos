package com.awesome.demos.test.Activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * Created by Mjj on 2018/8/7.
 */

public class FragmentActivity2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String getTitles(){
        return "getTitle";
    }
}
