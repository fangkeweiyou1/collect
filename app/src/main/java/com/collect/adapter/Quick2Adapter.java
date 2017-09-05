package com.collect.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.collect.R;

import java.util.List;

/**
 * Created by zhangyuncai on 2017/8/29.
 */

public class Quick2Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public Quick2Adapter(Context context, @Nullable List data) {
        super(R.layout.adapter_test, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
