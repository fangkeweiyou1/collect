package com.collect.component;

import com.collect.annotationstest.PerActivity;
import com.collect.module.Test1Module;
import com.collect.test.Test1Activity;

import dagger.Component;

/**
 * Created by zhangyuncai on 2017/8/11.
 */
@PerActivity
@Component(modules = Test1Module.class, dependencies = BaseComponent.class)
public interface Test1Component {
    void inject(Test1Activity activity);
}
