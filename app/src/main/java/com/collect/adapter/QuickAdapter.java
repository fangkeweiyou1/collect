package com.collect.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.collect.R;
import com.collect.model.TestModel;

import java.util.List;

/**
 * Created by zhangyuncai on 2017/8/29.
 */

public class QuickAdapter extends BaseQuickAdapter<TestModel, BaseViewHolder> {
    public QuickAdapter(Context context, @Nullable List data) {
        super(R.layout.adapter_test, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestModel item) {
        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_content, item.getContent());

    }

}
