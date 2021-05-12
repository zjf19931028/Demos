package com.awesome.viewpagerdemo.viewpager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.awesome.sdk.util.ShowLogUtil;
import com.awesome.viewpagerdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 * banner图
 */
public class BannerActivity extends AppCompatActivity {

    private ViewPager mViewPager1;
    private ViewPager mViewPagerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager1 = findViewById(R.id.viewPager1);

        // 每页为View
        List<View> mViews = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.mipmap.ic_launcher);
            mViews.add(imageView);
        }
        BannerAdapter adapter = new BannerAdapter(mViews);
        mViewPager1.setAdapter(adapter);
        // 向前后预加载的个数
        mViewPager1.setOffscreenPageLimit(1);
        mViewPager1.setCurrentItem(Integer.MAX_VALUE / 2);
        mViewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ShowLogUtil.info("mViewPager1 position=" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        // 每页为Fragment
        Fragment[] fragments = new Fragment[]{
                TextFragment.newInstance("1"),
                TextFragment.newInstance("2"),
                TextFragment.newInstance("3")
        };
        mViewPagerFragment = findViewById(R.id.viewPagerFragment);
        mViewPagerFragment.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                ShowLogUtil.info("getItem=" + position);
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        });
        mViewPagerFragment.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ShowLogUtil.info("mViewPager2 position=" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}