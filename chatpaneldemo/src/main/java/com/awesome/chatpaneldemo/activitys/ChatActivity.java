package com.awesome.chatpaneldemo.activitys;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.InspectableProperty;
import androidx.appcompat.app.AppCompatActivity;

import com.awesome.chatpaneldemo.R;
import com.awesome.chatpaneldemo.util.KeyboardUtil;
import com.awesome.sdk.base.BaseActivity;
import com.awesome.sdk.constant.Constant;
import com.awesome.sdk.util.ShowLogUtil;

import net.qiujuer.widget.airpanel.AirPanelFrameLayout;


public class ChatActivity extends BaseActivity implements PanelFragment.PanelCallback {
    private PanelFragment mPanelFragment;
    private EditText mEditText;
//    private AirPanelFrameLayout airPanelSubLayout;

    @InspectableProperty.EnumEntry(value = 1)
    private int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mEditText = findViewById(R.id.edit_content);
//        airPanelSubLayout = findViewById(R.id.airPanelSubLayout);

        if (!hasPermission(Constant.WRITE_EXTERNAL_PERMISSION)) {
            requestPermission(Constant.WRITE_EXTERNAL_CODE, Constant.WRITE_EXTERNAL_PERMISSION);
        }

        mPanelFragment = (PanelFragment) getSupportFragmentManager().findFragmentById(R.id.frag_panel);
        mPanelFragment.setup(this);
        findViewById(R.id.btn_face).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPanelFragment.showFace();
//                airPanelSubLayout.openPanel();
                if (KeyboardUtil.isKeyboardShown(ChatActivity.this)) {
                    KeyboardUtil.hideKeyboard(ChatActivity.this);
                }
            }
        });
//        findViewById(R.id.edit_content).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction()==MotionEvent.ACTION_DOWN){
//                    mPanelFragment.hideAll();
//                }
//                return false;
//            }
//        });

    }

    @Override
    public EditText getInputEditText() {
        return mEditText;
    }

}