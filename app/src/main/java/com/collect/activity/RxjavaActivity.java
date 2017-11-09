package com.collect.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.collect.R;
import com.collect.base.BaseActivity;

import java.util.concurrent.TimeUnit;

import cn.campusapp.router.annotation.RouterMap;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by zhangyuncai on 2017/8/19.
 */
@RouterMap("activity://rxjava")
public class RxjavaActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);


        Flowable.timer(5000,TimeUnit.MILLISECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        System.out.println("-----------------<<<>>>--------------------aLong="+aLong);
                    }
                });

    }
}
