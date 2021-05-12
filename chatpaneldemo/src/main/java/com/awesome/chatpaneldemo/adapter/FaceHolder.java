package com.awesome.chatpaneldemo.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.awesome.chatpaneldemo.R;
import com.awesome.chatpaneldemo.bean.Face;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/12 13:57
 * Description:
 */
public class FaceHolder extends RecyclerAdapter.ViewHolder<Face.Bean> {
    private ImageView mFace;

    public FaceHolder(@NonNull View itemView) {
        super(itemView);
        mFace = itemView.findViewById(R.id.im_face);
    }

    @Override
    protected void onBind(Face.Bean bean) {
        if (bean != null &&
                // drawable 资源 id
                (bean.source instanceof Integer)
                // face zip包资源路径
                || bean.preview instanceof String) {
            Glide.with(itemView.getContext())
                    .load(bean.preview)
                    .format(DecodeFormat.PREFER_ARGB_8888) //设置解码格式8888，保证清晰度
                    .placeholder(R.drawable.default_face)
                    .into(mFace);
        }
    }
}
