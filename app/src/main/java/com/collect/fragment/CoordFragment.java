package com.collect.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.collect.R;
import com.collect.adapter.Quick2Adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zhangyuncai on 2017/9/4.
 */

public class CoordFragment extends Fragment {
    @BindView(R.id.recyclerview_coord)
    RecyclerView mRecyclerView;
    Unbinder unbinder;

    public static CoordFragment newInstance() {
        return new CoordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_coord, null);
        unbinder = ButterKnife.bind(this, view);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add("dd");
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(new Quick2Adapter(getContext(), list));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
