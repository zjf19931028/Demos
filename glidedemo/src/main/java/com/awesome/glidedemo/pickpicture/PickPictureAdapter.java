package com.awesome.glidedemo.pickpicture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awesome.glidedemo.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/7 14:35
 * Description: 选择图片
 */
public class PickPictureAdapter extends RecyclerView.Adapter<PickPictureAdapter.ViewHolder> {

    private Context mContext;
    private List<Image> mImages;

    public PickPictureAdapter(Context context, List<Image> images) {
        mContext = context;
        mImages = images;
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
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_pick_picture);
        }
    }
}
