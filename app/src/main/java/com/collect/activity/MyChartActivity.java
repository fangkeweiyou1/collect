package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.collect.R;
import com.collect.base.BaseActivity;
import com.collect.view.ChartInfoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/28.
 */
@RouterMap("activity://mychart")
public class MyChartActivity extends BaseActivity {
    @BindView(R.id.civ)
    ChartInfoView civ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mychart);
        ButterKnife.bind(this);
    }
}
