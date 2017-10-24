package com.collect.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.collect.R;

import cn.campusapp.router.annotation.RouterMap;


/**
 * Created by zhangyuncai on 2017/9/27.
 */
@RouterMap("activity://test5")
public class Test5Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);
    }
}
