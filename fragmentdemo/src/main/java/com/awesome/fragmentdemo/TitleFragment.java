package com.awesome.fragmentdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/25 10:01
 * Description:
 */
public class TitleFragment extends Fragment {

    public static final String TITLE = "title";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString(TITLE);
            if (!TextUtils.isEmpty(title)) {
                TextView textView = view.findViewById(R.id.tv);
                textView.setText(title);
            }
        }
        return view;
    }

    public static TitleFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(TITLE, title);
        TitleFragment fragment = new TitleFragment();
        fragment.setArguments(args);
        return fragment;
    }


}


