package com.awesome.uidemo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.awesome.uidemo.R;

public class ChatActivity extends AppCompatActivity implements PanelFragment.PanelCallback {
    private PanelFragment mPanelFragment;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mEditText = findViewById(R.id.edit_content);
        mPanelFragment = (PanelFragment) getSupportFragmentManager().findFragmentById(R.id.frag_panel);
        mPanelFragment.setup(this);

        findViewById(R.id.btn_face).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPanelFragment.showFace();
            }
        });
    }

    @Override
    public EditText getInputEditText() {
        return mEditText;
    }


}