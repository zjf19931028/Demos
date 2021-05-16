package com.awesome.chatpaneldemo.activitys.jeejio.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.awesome.chatpaneldemo.R;
import com.awesome.chatpaneldemo.util.KeyboardUtil;

public class ChatInputActivity extends AppCompatActivity implements PanelFragment.PanelCallback {
    private PanelFragment mPanelFragment;
    private ImageView mBtnFace;
    private EditText mEtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_input);

        mPanelFragment = (PanelFragment) getSupportFragmentManager().findFragmentById(R.id.frag_panel);
        mPanelFragment.setup(this);

        mBtnFace = findViewById(R.id.btn_face);
        mEtInput = findViewById(R.id.et_input);

        mBtnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPanelFragment.showFace();
                if (KeyboardUtil.isKeyboardShown(ChatInputActivity.this)) {
                    KeyboardUtil.hideKeyboard(ChatInputActivity.this);
                }
            }
        });

        mEtInput.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mPanelFragment.hideAll();
                        if (!KeyboardUtil.isKeyboardShown(ChatInputActivity.this)) {
                            KeyboardUtil.showKeyboard(ChatInputActivity.this, mEtInput);
                        }
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public EditText getInputEditText() {
        return mEtInput;
    }
}