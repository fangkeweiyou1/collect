package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.collect.R;
import com.collect.adapter.TestAdpater;
import com.collect.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/15.
 */
@RouterMap("activity://coordinator2")
public class Coordinator2Activity extends BaseActivity implements TestAdpater.TestListener {
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private TestAdpater mAdpater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator2);
        ButterKnife.bind(this);

        mAdpater = new TestAdpater(this, this);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.setAdapter(mAdpater);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onClickItem(String content) {

    }
}
