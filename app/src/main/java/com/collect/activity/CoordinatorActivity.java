package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;

import com.collect.R;
import com.collect.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/12.
 */
@RouterMap("activity://coordinator")
public class CoordinatorActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        findViewById(R.id.btn).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    view.setX(motionEvent.getRawX() - view.getWidth() / 2);
                    view.setY(motionEvent.getRawY() - view.getHeight() / 2);
                }
                return true;

            }
        });
    }
}
