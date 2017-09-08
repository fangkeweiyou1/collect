package com.collect.test;

import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.collect.R;
import com.collect.adapter.TestAdpater;
import com.collect.annotationstest.WeekDays;
import com.collect.base.BaseActivity;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;
import refresh.AutoLoadRefreshLayout;
import refresh.AutoRefreshListener;

/**
 * Created by zhangyuncai on 2017/8/16.
 */
@RouterMap("activity://test3")
public class Test3Activity extends BaseActivity {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.auto)
    AutoLoadRefreshLayout auto;

    @WeekDays
    int type = 10;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        ButterKnife.bind(this);

        setType(100);

        initView();

        initData();

        initEvent();

    }

    private void initView() {
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(new TestAdpater(this, 20));

        auto.setHeaderViewGone();
        auto.setFootViewGone();



    }

    private void setType(@IntRange(from = 0, to = 100) int type) {
        this.type = type;
    }

    private void setType2(@WeekDays int type) {
        this.type = type;
    }

    private void initData() {

    }

    private void initEvent() {
        auto.setOnRefreshListener(new AutoRefreshListener() {
            @Override
            public void onPullDownToRefresh(TwinklingRefreshLayout refreshLayout) {
            }

            @Override
            public void onPullUpToRefresh(TwinklingRefreshLayout refreshLayout) {
            }

            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {

            }
        });
    }
}


//