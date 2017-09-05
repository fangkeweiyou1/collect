package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.collect.R;
import com.collect.adapter.Quick2Adapter;
import com.collect.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/9/5.
 */
@RouterMap("activity://recycleranimator")
public class RecyclerAnimatorActivity extends BaseActivity {
    @BindView(R.id.recyclerview_recycleranimator)
    RecyclerView mRecyclerView;
    private Quick2Adapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleranimator);
        ButterKnife.bind(this);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("");
        }
        mAdapter = new Quick2Adapter(this, list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }
}
