package com.awesome.dialogdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import static android.view.Gravity.BOTTOM;

/**
 * Created by Alice on 2020/7/12
 */
public class MyDialogView extends DialogFragment {
    public MyDialogView() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_delete_video,container,false);
        String title = getArguments().getString("title");
        ((TextView)view.findViewById(R.id.title)).setText(title);
        view.findViewById(R.id.positive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "确定", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        view.findViewById(R.id.negative).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"取消",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.width=WindowManager.LayoutParams.MATCH_PARENT;
        params.height=WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(params);
        window.setGravity(BOTTOM);
//        window.setBackgroundDrawableResource(android.R.color.white);
//        window.getDecorView().setPadding(0,0,0,0);
        super.onResume();
    }

    public static MyDialogView newInstance(String title){
        MyDialogView dialog=new MyDialogView();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        dialog.setArguments(bundle);
//        dialog.setStyle(DialogFragment.STYLE_NORMAL,R.style.Dialog_FullScreen);
        return dialog;
    }
}
