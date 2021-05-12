package com.awesome.chatpaneldemo.adapter;

import android.view.View;

import com.awesome.chatpaneldemo.R;
import com.awesome.chatpaneldemo.bean.Face;

import java.util.List;


/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/5/12 13:55
 * Description: 表情列表的适配器
 */
public class FaceAdapter extends RecyclerAdapter<Face.Bean> {
    public FaceAdapter(List<Face.Bean> beans, AdapterListener<Face.Bean> listener) {
        super(beans, listener);
    }

    @Override
    protected int getItemViewType(int position, Face.Bean bean) {
        return R.layout.cell_face;
    }

    @Override
    protected ViewHolder<Face.Bean> onCreateViewHolder(View root, int viewType) {
        return new FaceHolder(root);
    }

    @Override
    public void update(Face.Bean bean, ViewHolder<Face.Bean> holder) {

    }
}
