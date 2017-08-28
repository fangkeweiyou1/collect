package com.collect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.collect.R;

/**
 * Created by zhangyuncai on 2017/8/28.
 */

public class ChartInfoView extends LinearLayout {
    private LayoutInflater mLayoutInflater;

    public ChartInfoView(Context context) {
        super(context);

        init();
    }

    public ChartInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public ChartInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mLayoutInflater = LayoutInflater.from(getContext());
        mLayoutInflater.inflate(R.layout.view_chartinfo,this);
    }

    private void initView() {

    }

    private void initEvent() {
    }


}
