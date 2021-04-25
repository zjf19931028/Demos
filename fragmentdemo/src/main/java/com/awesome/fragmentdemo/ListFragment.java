package com.awesome.fragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.awesome.sdk.util.ShowLogUtil;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/25 09:51
 * Description:
 */
public class ListFragment extends Fragment {

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ShowLogUtil.info("onAttach " + "Fragment和Activity建立关联");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ShowLogUtil.info("onCreate ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ShowLogUtil.info("onCreateView " + "Fragment创建视图");
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        ShowLogUtil.info("onActivityCreated " + "相关联的Activity的onCreate已调用完成时");
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onStart() {
        super.onStart();
        ShowLogUtil.info("onStart ");
    }

    @Override
    public void onResume() {
        super.onResume();
        ShowLogUtil.info("onResume ");
    }

    @Override
    public void onPause() {
        super.onPause();
        ShowLogUtil.info("onPause ");
    }

    @Override
    public void onStop() {
        super.onStop();
        ShowLogUtil.info("onStop ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ShowLogUtil.info("onDestroyView " + "Fragment移除视图时");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ShowLogUtil.info("onDestroy ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ShowLogUtil.info("onDetach " + "Activity和Fragment解除关联时");
    }



}

