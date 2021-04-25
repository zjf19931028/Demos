package com.awesome.viewpagerdemo.viewpager;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.awesome.sdk.util.ShowLogUtil;

import java.util.List;

/**
 * Author: JfangZ
 * Email: zhangjingfang@jeejio.com
 * Date: 2021/4/25 11:45
 * Description:
 */
public class BannerAdapter extends PagerAdapter {
    private List<View> mViews;

    public BannerAdapter(List<View> views) {
        mViews = views;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    /**
     * 是否为同一View
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        ShowLogUtil.info(view == object);
        return view == object;
    }

    /**
     * 把预加载的View添加到父容器中
     * @param container
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ShowLogUtil.info("instantiateItem position=" + (position % mViews.size()));
        View view = mViews.get(position % mViews.size());
        container.addView(view);
        return view;
    }

    /**
     * 从父容器中删除View
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ShowLogUtil.info("destroyItem position=" + (position % mViews.size()));
        container.removeView(mViews.get(position % mViews.size()));
    }
}
