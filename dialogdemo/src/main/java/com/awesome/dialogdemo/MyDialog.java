package com.awesome.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * Created by Alice on 2020/7/12
 */
public class MyDialog extends DialogFragment {
    public MyDialog() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String title = getArguments().getString("title");
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle(title);
        builder.setMessage("删除歌曲？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"确定",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getContext(),"取消",Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    public static MyDialog newInstance(String title){
        MyDialog dialog=new MyDialog();
        Bundle bundle=new Bundle();
        bundle.putString("title",title);
        dialog.setArguments(bundle);
        return dialog;
    }
}
