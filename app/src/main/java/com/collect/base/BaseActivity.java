package com.collect.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.utils.AppDavikActivityMgr;

/**
 * Created by zhangyuncai on 2017/7/3.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDavikActivityMgr.getScreenManager().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppDavikActivityMgr.getScreenManager().removeActivity(this);
    }
}
