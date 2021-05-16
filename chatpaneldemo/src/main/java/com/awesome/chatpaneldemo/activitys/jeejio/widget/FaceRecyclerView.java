package com.awesome.chatpaneldemo.activitys.jeejio.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.awesome.chatpaneldemo.R;
import com.awesome.chatpaneldemo.adapter.FaceAdapter;
import com.awesome.chatpaneldemo.adapter.RecyclerAdapter;
import com.awesome.chatpaneldemo.bean.Face;

import java.util.List;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/13 11:31
 * Description:
 */
public class FaceRecyclerView extends RelativeLayout {
    private RecyclerView mRecyclerView;

    public FaceRecyclerView(Context context) {
        super(context);
        init();
    }


    public FaceRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FaceRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));

        // 设置Adapter
        List<Face.Bean> faces = Face.all(getContext()).get(0).faces;
        FaceAdapter adapter = new FaceAdapter(faces, new RecyclerAdapter.AdapterListener<Face.Bean>() {
            @Override
            public void onItemClick(RecyclerAdapter.ViewHolder holder, Face.Bean bean) {
//                ShowLogUtil.info("onItemClick");
//                if (mCallback == null)
//                    return;
//                // 表情添加到输入框
//                EditText editText = mCallback.getInputEditText();
//                Face.inputFace(getContext(), editText.getText(), bean,
//                        (int) (editText.getTextSize() + Ui.dipToPx(getResources(), 2)));

            }

            @Override
            public void onItemLongClick(RecyclerAdapter.ViewHolder holder, Face.Bean bean) {

            }
        });
        recyclerView.setAdapter(adapter);
        addView(recyclerView);

        LinearLayout linearLayout=new LinearLayout(getContext());
        linearLayout.setBackgroundColor(Color.parseColor("#eeeeee"));
        linearLayout.setPadding(30,30,30,30);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        RelativeLayout.LayoutParams llLp = new RelativeLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llLp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        llLp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        linearLayout.setLayoutParams(llLp);
        addView(linearLayout);


        ImageView ivDelete = new ImageView(getContext());
        ivDelete.setImageResource(R.drawable.iv_chat_face_delete_enabled);
        ivDelete.setBackgroundColor(Color.WHITE);
        ivDelete.setPadding(30,30,30,30);
        LinearLayout.LayoutParams ivDeleteLp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        ivDeleteLp.leftMargin = 40;
        ivDeleteLp.rightMargin = 50;
        ivDelete.setLayoutParams(ivDeleteLp);
        linearLayout.addView(ivDelete);

        TextView tvSend = new TextView(getContext());
        tvSend.setText("发送");
        tvSend.setTextColor(Color.WHITE);
        tvSend.setBackgroundColor(Color.parseColor("#5A90FB"));
        tvSend.setPadding(30,30,30,30);
        LinearLayout.LayoutParams tvSendLp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        tvSendLp.rightMargin = 40;
        tvSend.setLayoutParams(tvSendLp);
        linearLayout.addView(tvSend);

    }
}
