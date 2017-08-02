package com.collect.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.collect.R;
import com.collect.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/2.
 * 测试界面1
 */
@RouterMap({"activity://test1"})
public class Test1Activity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        Intent intent = new Intent();
        intent.setAction("broadcasttest");
        sendBroadcast(intent);


    }
}
