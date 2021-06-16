package com.awesome.demos.test.Activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Mjj on 2018/8/7.
 */

public class FragmentActivity1 extends Activity {
    public String productId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = new Bundle();
        bundle.putString(Constant.INTENT_ID, productId);
        Fragment fragment = null;
        fragment.setArguments(bundle);
    }
}
