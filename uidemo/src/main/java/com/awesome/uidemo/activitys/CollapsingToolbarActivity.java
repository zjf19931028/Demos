package com.awesome.uidemo.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.awesome.uidemo.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.jaeger.library.StatusBarUtil;

/**
 * 折叠标题栏
 */
public class CollapsingToolbarActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);
        StatusBarUtil.setColor(this,getResources().getColor(R.color.teal_200));
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        appBarLayout = findViewById(R.id.appBarLayout);
        collapsingToolbarLayout.setExpandedTitleColor(Color.YELLOW);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.BLUE);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

            }
        });
    }
}