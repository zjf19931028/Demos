package com.awesome.demos.test.Activity;


import androidx.fragment.app.Fragment;

/**
 * Created by Mjj on 2018/8/9.
 */

public class Fragment1 extends Fragment {
    public String productId;
    @Override
    public void onStart() {
        super.onStart();
        if (isAdded()) {//判断Fragment已经依附Activity
            productId = getArguments().getString(Constant.INTENT_ID);
        }
    }
}
