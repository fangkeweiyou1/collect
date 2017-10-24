package com.collect.adapter;

import android.support.annotation.LayoutRes;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyuncai on 2017/9/22.
 */

public class Quick3Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
    static List<String> datas;

    static {
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("测试" + i);
        }
    }

    public Quick3Adapter(@LayoutRes int layoutResId) {

        super(layoutResId, datas);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }

}
