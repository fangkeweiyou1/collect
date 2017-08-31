package com.wivesidedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gjiazhe.wavesidebar.WaveSideBar;

import java.util.List;

/**
 * Created by zhangyuncai on 2017/8/31.
 */

public class WaveSideActivity extends AppCompatActivity {

    private RecyclerView mRecyclerVeiw;
    private MyAdapter mAdapter;
    private WaveSideBar side_bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waveside);

        side_bar = (WaveSideBar) findViewById(R.id.side_bar);
        mRecyclerVeiw = (RecyclerView) findViewById(R.id.recyclerview);
        mAdapter = new MyAdapter();
        mRecyclerVeiw.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerVeiw.setAdapter(mAdapter);

        side_bar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {
                System.out.println("-----------------<<<>>>--------------------index=" + index);
                List<Contact> contacts = mAdapter.getContacts();
                for (int i = 0; i < contacts.size(); i++) {
                    if (contacts.get(i).getIndex().equals(index)) {
                        ((LinearLayoutManager) mRecyclerVeiw.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                        return;
                    }
                }
            }
        });

        initView();

        initData();
    }

    private void initView() {


    }

    private void initData() {

    }


}
