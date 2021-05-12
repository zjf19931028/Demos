package com.awesome.uidemo.adapter;

/**
 * Created by Alice on 2021/4/24
 */
public interface AdapterCallback<Data> {
    void update(Data data, RecyclerAdapter.ViewHolder<Data> holder);

}
