package com.awesome.demos.test.Activity;

import android.app.Activity;

import androidx.fragment.app.Fragment;

/**
 * Created by Mjj on 2018/8/9.
 */

public class Fragment2 extends Fragment {
    public String titles;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        titles = ((FragmentActivity2) activity).getTitles();//通过强转成宿主activity，就可以获取到传递过来的数据
    }
}
