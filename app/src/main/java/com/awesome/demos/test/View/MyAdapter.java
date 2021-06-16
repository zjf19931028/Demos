package com.awesome.demos.test.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.awesome.demos.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mjj on 2018/8/30.
 */

public class MyAdapter extends BaseAdapter {
    private Context mContext;

    private List<Integer> list = new ArrayList<>();

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.item_text);
            holder.imageView = convertView.findViewById(R.id.item_image);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(R.string.app_name);
        holder.imageView.setImageResource(R.drawable.ic_launcher_background);

        return convertView;
    }

    static class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}
