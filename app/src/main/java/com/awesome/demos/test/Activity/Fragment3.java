package com.awesome.demos.test.Activity;

import android.app.Activity;
import android.view.View;

import androidx.fragment.app.Fragment;

/**
 * Created by Mjj on 2018/8/8.
 */

public class Fragment3 extends Fragment implements View.OnClickListener {
    // 2.1 定义用来与外部activity交互，获取到宿主activity
    private FragmentListener listener;

    // 1 定义了所有activity必须实现的接口方法
    public interface FragmentListener {
        void process(String str);
    }

    // 当Fragment被加载到activity的时候会被回调
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(activity instanceof FragmentListener) {
            listener = (FragmentListener)activity; // 2.2 获取到宿主activity并赋值
        } else{
            throw new IllegalArgumentException("activity must implements FragmentListener");
        }
    }

    @Override
    public void onClick(View v) {
        listener.process("我是接口"); //3.1 执行回调
    }

    //把传递进来的activity对象释放掉
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
