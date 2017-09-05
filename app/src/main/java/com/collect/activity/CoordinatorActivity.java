package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.collect.R;
import com.collect.adapter.CoordPagerAdapter;
import com.collect.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/12.
 */
@RouterMap("activity://coordinator")
public class CoordinatorActivity extends BaseActivity {

    @BindView(R.id.tabs)
    TabLayout tabs;
//    @BindView(R.id.collapse_toolbar)
//    CollapsingToolbarLayout collapse_toolbar;
    @BindView(R.id.vp_coord)
    ViewPager vp_coord;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        ButterKnife.bind(this);


        initView();

        initData();

        initEvent();
    }

    private void initView() {
        vp_coord.setAdapter(new CoordPagerAdapter(getSupportFragmentManager()));
        tabs.setupWithViewPager(vp_coord);
    }

    private void initData() {

    }

    private void initEvent() {

    }
}
