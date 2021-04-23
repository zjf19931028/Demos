package com.awesome.uidemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditTextActivity extends AppCompatActivity {

    private EditText mEditText;

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        mEditText = findViewById(R.id.editView);
        Drawable handleLeft = mEditText.getTextSelectHandleLeft();
        Drawable handleRight = mEditText.getTextSelectHandleRight();
        handleLeft.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        handleRight.setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        mEditText.setTextSelectHandleLeft(handleLeft);
        mEditText.setTextSelectHandleRight(handleRight);
        mEditText.setHighlightColor(Color.YELLOW);
    }
}