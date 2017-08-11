package com.collect.component;

import com.collect.module.TestModule;
import com.collect.test.Test1Activity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhangyuncai on 2017/8/10.
 */
@Singleton
@Component(modules = TestModule.class)
public interface TestComponent {
    void inject(Test1Activity activity);
}
