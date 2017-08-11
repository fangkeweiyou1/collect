package com.collect.activity;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.collect.R;
import com.collect.base.BaseActivity;
import com.collect.component.DaggerMainComponent;
import com.collect.component.MainComponent;
import com.collect.model.Cloth;
import com.collect.module.MainModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/5.
 * 学习dagger2的使用
 */
@RouterMap({"activity://dagger2"})
public class DaggerActivity extends BaseActivity {
    @BindView(R.id.tv_test)
    TextView tvTest;
    @Inject
    Cloth cloth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        ButterKnife.bind(this);

        MainComponent build = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        build.inject(this);


        String color = cloth.getColor();
//        System.out.println("-----------------<<<>>>--------------------color=" + color);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, 100);

        new Thread(){
            @Override
            public void run() {
                boolean b = Looper.myLooper() == Looper.getMainLooper();
                System.out.println("-----------------<<<>>>--------------------是否主线程=" + b);
            }
        }.start();


    }

}
