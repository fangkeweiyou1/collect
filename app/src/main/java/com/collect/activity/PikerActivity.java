package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.collect.R;
import com.collect.adapter.QuickAdapter;
import com.collect.base.BaseActivity;
import com.collect.model.TestModel;
import com.example.zhouwei.library.CustomPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/29.
 */
@RouterMap("activity://piker")
public class PikerActivity extends BaseActivity {
    @BindView(R.id.tv_piker)
    TextView tv_piker;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    private List<TestModel> list;
    private int testSize = 3;
    private CustomPopWindow mListPopWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piker);
        ButterKnife.bind(this);

        addTestData();

        tv_piker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopListView();
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new QuickAdapter(this, list));
    }

    private void showPiker(View v) {
    }

    private void showPopListView() {
        View contentView = LayoutInflater.from(this).inflate(R.layout.pop_list, null);
        //处理popWindow 显示内容
        handleListView(contentView);
        //创建并显示popWindow
        if (mListPopWindow == null) {
            mListPopWindow = new CustomPopWindow.PopupWindowBuilder(this)
                    .setView(contentView)
                    .size(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)//显示大小
                    .create();

        }
        mListPopWindow.showAsDropDown(tv_piker, 0, 20);
    }


    private void handleListView(View contentView) {
        RecyclerView recyclerView = (RecyclerView) contentView.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(new QuickAdapter(this, list));
    }


    private void addTestData() {
        list = new ArrayList<>();

        TestModel model;

        for (int i = 0; i < testSize; i++) {
            model = new TestModel();
            model.setName("测试名称" + i);
            model.setContent("测试内容" + i);
            list.add(model);

        }
    }
}
