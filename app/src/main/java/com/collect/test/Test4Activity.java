package com.collect.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.collect.R;
import com.collect.adapter.Test4Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;


/**
 * Created by zhangyuncai on 2017/9/27.
 */
@RouterMap("activity://test4")
public class Test4Activity extends AppCompatActivity {
    @BindView(R.id.tv_test4_tv)
    TextView tv_test4_tv;
    @BindView(R.id.map)
    MapView mapView;
    private Test4Adapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        ButterKnife.bind(this);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        AMap aMap = mapView.getMap();

    }
}

