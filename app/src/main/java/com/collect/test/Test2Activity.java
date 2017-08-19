package com.collect.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.collect.CollectApplication;
import com.collect.R;
import com.collect.base.BaseActivity;
import com.collect.component.DaggerTest2Component;
import com.collect.model.Test2Model;
import com.collect.module.Test2Module;

import java.util.Date;

import javax.inject.Inject;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/11.
 */
@RouterMap({"activity://test2"})
public class Test2Activity extends BaseActivity {

    @Inject
    Test2Model test2Model;
    private Date date1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        DaggerTest2Component
                .builder()
                .baseComponent(((CollectApplication) getApplication()).getBaseComponent())
                .test2Module(new Test2Module())
                .build()
                .inject(this);

        date1 = new Date();
        findViewById(R.id.tv_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date2 = new Date();
                long l = date2.getTime() - date1.getTime();
                System.out.println("-----------------<<<>>>--------------------l=" + l);
                date1 =date2;
            }
        });

    }
}
