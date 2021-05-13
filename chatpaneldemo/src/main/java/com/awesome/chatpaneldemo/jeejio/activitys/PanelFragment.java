package com.awesome.chatpaneldemo.jeejio.activitys;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.awesome.chatpaneldemo.R;
import com.awesome.chatpaneldemo.adapter.FaceAdapter;
import com.awesome.chatpaneldemo.adapter.RecyclerAdapter;
import com.awesome.chatpaneldemo.bean.Face;
import com.awesome.chatpaneldemo.jeejio.widget.FaceRecyclerView;
import com.awesome.chatpaneldemo.util.Ui;
import com.awesome.chatpaneldemo.util.UiTool;
import com.awesome.sdk.util.ShowLogUtil;
import com.google.android.material.tabs.TabLayout;

import java.util.List;


/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/12 11:22
 * Description: 面板实现
 */
public class PanelFragment extends Fragment {
    private View mFacePanel, mGalleryPanel, mRecordPanel;

    private PanelCallback mCallback;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_panel, container, false);
        initFace(root);
        initRecord(root);
        initGallery(root);
        return root;
    }

    public void setup(PanelCallback callback) {
        mCallback = callback;
    }

    // 初始化表情
    private void initFace(View root) {
        final View facePanel = mFacePanel = root.findViewById(R.id.layout_panel_face);
        View backspaceView = facePanel.findViewById(R.id.btn_backspace);
        View sendView = facePanel.findViewById(R.id.btn_send);
        LinearLayout llDoFace = facePanel.findViewById(R.id.ll_do_face);
        TabLayout tabLayout = (TabLayout) facePanel.findViewById(R.id.tab);
        ViewPager viewPager = (ViewPager) facePanel.findViewById(R.id.pager);
        backspaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 删除逻辑
                PanelCallback callback = mCallback;
                if (callback == null)
                    return;
                // 模拟一个键盘删除点击
                KeyEvent event = new KeyEvent(0, 0, 0, KeyEvent.KEYCODE_DEL,
                        0, 0, 0, 0, KeyEvent.KEYCODE_ENDCALL);
                callback.getInputEditText().dispatchKeyEvent(event);
            }
        });
        sendView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
        // 每一表情显示48dp
        final int minFaceSize = (int) Ui.dipToPx(getResources(), 48);
        final int totalScreen = UiTool.getScreenWidth(getActivity());
        final int spanCount = totalScreen / minFaceSize;

        // 每一表情显示96dp
        final int sEMinFaceSize = (int) Ui.dipToPx(getResources(), 96);
        final int sETotalScreen = UiTool.getScreenWidth(getActivity());
        final int sESpanCount = sETotalScreen / sEMinFaceSize;


        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return Face.all(getContext()).size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {

                LayoutInflater inflater = LayoutInflater.from(getContext());
                RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.layout_face_content, container, false);
                if (position == 0) {
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), spanCount));
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), sESpanCount));
                }

                // 设置Adapter
                List<Face.Bean> faces = Face.all(getContext()).get(position).faces;
                FaceAdapter adapter = new FaceAdapter(faces, new RecyclerAdapter.AdapterListener<Face.Bean>() {
                    @Override
                    public void onItemClick(RecyclerAdapter.ViewHolder holder, Face.Bean bean) {
                        if (mCallback == null)
                            return;
                        // 表情添加到输入框
                        EditText editText = mCallback.getInputEditText();
                        Face.inputFace(getContext(), editText.getText(), bean,
                                (int) (editText.getTextSize() + Ui.dipToPx(getResources(), 2)));

                    }

                    @Override
                    public void onItemLongClick(RecyclerAdapter.ViewHolder holder, Face.Bean bean) {
                    }
                });
                recyclerView.setAdapter(adapter);

                // 添加
                container.addView(recyclerView);
                return recyclerView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(container);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return Face.all(getContext()).get(position).name;
            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    llDoFace.setVisibility(View.VISIBLE);
                } else {
                    llDoFace.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // 初始化语音
    private void initRecord(View root) {

    }

    // 初始化图片
    private void initGallery(View root) {

    }

    public void showFace() {
        mFacePanel.setVisibility(View.VISIBLE);
    }

    public void showRecord() {
    }

    public void showGallery() {

    }

    public void hideAll() {
        mFacePanel.setVisibility(View.GONE);
    }

    // tip:接口回调传递数据
    // 回调聊天界面Callback
    public interface PanelCallback {
        EditText getInputEditText();
    }
}
