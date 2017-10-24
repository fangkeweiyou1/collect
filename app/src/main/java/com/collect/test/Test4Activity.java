package com.collect.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.collect.R;
import com.collect.adapter.Test4Adapter;
import com.collect.decoration.MyDecoration;
import com.collect.model.Test11Model;
import com.collect.model.Test12Model;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;


/**
 * Created by zhangyuncai on 2017/9/27.
 */
@RouterMap("activity://test4")
public class Test4Activity extends AppCompatActivity {
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private Test4Adapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        ButterKnife.bind(this);

        List<MultiItemEntity> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 5 == 0) {

                list.add(new Test12Model());
            } else {
                list.add(new Test11Model());
            }
        }

        mAdapter = new Test4Adapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        MyDecoration myDecoration = new MyDecoration(this, DividerItemDecoration.VERTICAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(myDecoration);

    }
}
