package com.collect.component;

import com.collect.activity.DaggerActivity;
import com.collect.module.MainModule;

import dagger.Component;

/**
 * Created by zhangyuncai on 2017/8/5.
 */
@Component(modules = {MainModule.class})
public interface MainComponent {
    void inject(DaggerActivity daggerActivity);
}
