package com.awesome.chatpaneldemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.awesome.chatpaneldemo.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alice on 2021/4/24
 */
public abstract class RecyclerAdapter<Data> extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder<Data>>
        implements View.OnClickListener, View.OnLongClickListener, AdapterCallback<Data> {
    private final List<Data> mDataList;
    private AdapterListener<Data> mListener;

    /**
     * 构造模块
     */
    public RecyclerAdapter() {
        this(null);
    }

    public RecyclerAdapter(AdapterListener<Data> listener) {
        this(new ArrayList<>(),listener);
    }

    public RecyclerAdapter(List<Data> dataList, AdapterListener<Data> listener) {
        mDataList = dataList;
        mListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return getItemViewType(position, mDataList.get(position));
    }


    protected abstract int getItemViewType(int position, Data data);

    /**
     * 创建一个ViewHolder
     *
     * @param parent
     * @param viewType 约定为xml的布局id
     * @return
     */
    @NonNull
    @Override
    public ViewHolder<Data> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        ViewHolder<Data> holder = onCreateViewHolder(root, viewType);
        root.setOnClickListener(this);
        root.setOnLongClickListener(this);
        root.setTag(R.id.tag_recycler_holder, holder);
        holder.mCallback = this;
        return holder;
    }

    protected abstract ViewHolder<Data> onCreateViewHolder(View root, int viewType);

    /**
     * 绑定一个数据到Holder上
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder<Data> holder, int position) {
        Data data = mDataList.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void add(Data data) {
        mDataList.add(data);
        notifyItemInserted(mDataList.size() - 1);
    }


    public void add(Data... dataList) {
        if (dataList != null && dataList.length > 0) {
            int startPos = mDataList.size();
            Collections.addAll(mDataList, dataList);
            notifyItemRangeInserted(startPos, dataList.length);
        }
    }

    public void add(Collection<Data> dataList) {
        if (dataList != null && dataList.size() > 0) {
            int startPos = mDataList.size();
            mDataList.addAll(dataList);
            notifyItemRangeInserted(startPos, dataList.size());
        }
    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    public void replace(Collection<Data> dataList) {
        mDataList.clear();
        if (dataList == null || dataList.size() == 0)
            return;
        mDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        ViewHolder holder = (ViewHolder) v.getTag(R.id.tag_recycler_holder);
        if (mListener != null) {
            int position = holder.getAdapterPosition();
            mListener.onItemClick(holder, mDataList.get(position));
        }
    }

    @Override
    public boolean onLongClick(View v) {
        ViewHolder holder = (ViewHolder) v.getTag(R.id.tag_recycler_holder);
        if (mListener != null) {
            int position = holder.getAdapterPosition();
            mListener.onItemLongClick(holder, mDataList.get(position));
            return true;
        }
        return false;
    }

    public void onListener(AdapterListener listener) {
        mListener = listener;
    }

    /**
     * 监听器
     *
     * @param <Data>
     */
    public interface AdapterListener<Data> {
        void onItemClick(ViewHolder holder, Data data);

        void onItemLongClick(ViewHolder holder, Data data);
    }

    public static abstract class ViewHolder<Data> extends RecyclerView.ViewHolder {
        protected Data mData;
        private AdapterCallback<Data> mCallback;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        /**
         * 绑定数据的触发
         *
         * @param data 绑定的数据
         */
        void bind(Data data) {
            mData = data;
            onBind(data);
        }

        /**
         * 当触发绑定数据的时候，必须回调。
         *
         * @param data
         */
        protected abstract void onBind(Data data);

        /**
         * Holder对自己对应的Data更新
         *
         * @param data
         */
        public void updateData(Data data) {
            if (mCallback != null) {
                mCallback.update(data, this);
            }

        }
    }
}