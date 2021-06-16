package com.awesome.demos.test.youhua;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

/**
 * Created by Mjj on 2018/8/28.
 */

public class Single1Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SingleInstance instance = SingleInstance.getInstance(getApplicationContext());

    }
}
