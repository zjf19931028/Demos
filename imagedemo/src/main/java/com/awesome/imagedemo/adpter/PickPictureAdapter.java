package com.awesome.imagedemo.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awesome.imagedemo.R;
import com.awesome.imagedemo.bean.Image;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/7 14:35
 * Description: 选择图片
 */
public class PickPictureAdapter extends RecyclerView.Adapter<PickPictureAdapter.ViewHolder> {
    private final int MAX_SELECTED_COUNT = 9;
    private Context mContext;
    private List<Image> mImages = new ArrayList<>();
    private List<Image> mSelectedImages = new LinkedList<>();
    private SelectedChangeListener mListener;

    public PickPictureAdapter(Context context, List<Image> selectedImages) {
        mContext = context;
        mSelectedImages = selectedImages;
    }

    public void setImages(List<Image> images) {
        mImages = images;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rcv_pick_picture, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mImages.get(position).path) // 加载路径
                .diskCacheStrategy(DiskCacheStrategy.NONE) // 不使用缓存，直接从原图加载
                .centerCrop() // 居中剪切
                .into(holder.mIvPicture);
        holder.mViewShade.setVisibility(mImages.get(position).isSelect ? View.VISIBLE : View.GONE);
        holder.mCbSelect.setChecked(mImages.get(position).isSelect);
//        holder.mTvDuration.setText(""+mImages.get(position).duration);
//        holder.mTvDuration.setVisibility(mImages.get(position).duration != 0 ? View.VISIBLE : View.GONE);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSelectedImages.contains(mImages.get(position))) {
                    mSelectedImages.remove(mImages.get(position));
                    mImages.get(position).isSelect = false;
                } else {
                    // 大于最大值提示信息
                    if (mSelectedImages.size() > (MAX_SELECTED_COUNT - 1)) {
                        return;
                    }
                    mSelectedImages.add(mImages.get(position));
                    mImages.get(position).isSelect = true;
                }
                // 界面数据刷新
                // 更改数据通知
                notifyItemChanged(position);
                mListener.onSelectedCountChanged(mSelectedImages.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIvPicture;
        private View mViewShade;
        private CheckBox mCbSelect;
        private TextView mTvDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIvPicture = itemView.findViewById(R.id.iv_pick_picture);
            mViewShade = itemView.findViewById(R.id.view_shade);
            mCbSelect = itemView.findViewById(R.id.cb_select);
            mTvDuration = itemView.findViewById(R.id.tv_duration);
        }
    }

    public void setSelectedCountChanged(SelectedChangeListener listener) {
        mListener = listener;
    }

    public interface SelectedChangeListener {
        void onSelectedCountChanged(int count);
    }
}
