package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.collect.R;
import com.collect.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/2.
 * 学习快捷键的使用
 */
@RouterMap({"activity://kuaijiejian"})
public class KuanjiejianActivity extends BaseActivity {
    //    private static final int kuaijiejian_const = 630;//TODO kuaijiejian_const
    //    private static final String kuaijianjian_key = "ONE";//TODO kuaijianjian_key
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuaijianjie);

        //TODO fbc
//        RelativeLayout viewById = (RelativeLayout) findViewById(R.id.rl_layout);
        //TODO gone
//        viewById.setVisibility(View.GONE);

        /*
        TODO kuanjiejian_ifn
         */
//        String str=null;
//        if (str == null) {
//
//        }
//
        /*
        TODO kuanjiejian_inn
         */
//        if (str != null) {
//
//        }

        /*
        TODO kuaijiejian_rouiT 快速从子线程切换到主线程
         */
//        new Thread(){
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });
//            }
//        }.start();

        //TODO kuaijiejian_Sfmt 快速格式化
//        String.format("%d", "kuaijiejian_Sfmt");

    }
}
