package com.collect.component;

import com.collect.annotationstest.PerActivity;
import com.collect.module.Test2Module;
import com.collect.test.Test2Activity;

import dagger.Component;

/**
 * Created by zhangyuncai on 2017/8/11.
 */
@PerActivity
@Component(modules = Test2Module.class, dependencies = BaseComponent.class)
public interface Test2Component {
    void inject(Test2Activity activity);
}

