package com.collect.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.collect.R;

import java.util.List;

/**
 * Created by zhangyuncai on 2017/10/6.
 */

public class Test4Adapter<T extends MultiItemEntity> extends BaseMultiItemQuickAdapter<T, BaseViewHolder> {

    public Test4Adapter(@Nullable List<T> data) {
        super(data);
        addItemType(11, R.layout.item_search_adapter);
        addItemType(12, R.layout.item_search_adapter12);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        helper.itemView.setTag(item);
    }
}
