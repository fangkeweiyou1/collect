package com.collect.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.collect.R;

/**
 * Created by zhangyuncai on 2017/9/22.
 */

public class Test3Adapter extends RecyclerView.Adapter<Test3Adapter.Test3ViewHolder>{

    @Override
    public Test3ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_test3,parent,false);

        return new Test3ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Test3ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 80;
    }

    public class Test3ViewHolder extends RecyclerView.ViewHolder{

        public Test3ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
