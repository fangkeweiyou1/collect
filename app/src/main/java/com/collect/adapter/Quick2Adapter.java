package com.collect.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.collect.R;
import com.utils.ToastUtils;

import java.util.List;

/**
 * Created by zhangyuncai on 2017/8/29.
 */

public class Quick2Adapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private List<String> list;

    public Quick2Adapter(Context context, @Nullable List data) {
        super(R.layout.adapter_test, data);
        this.list = data;
    }

    @Override
    protected void convert(final BaseViewHolder helper, String item) {
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = helper.getAdapterPosition();
                ToastUtils.showToast(position + "");
//                helper.get
                if (list != null && list.size() > position) {
                    notifyItemRemoved(position);
                    list.remove(position);
                }
            }
        });
    }

}
