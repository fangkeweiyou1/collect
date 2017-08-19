package com.collect.module;

import com.collect.model.Test2Model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangyuncai on 2017/8/11.
 */
@Module
public class BaseModule {

    @Singleton
    @Provides
    public Test2Model getTest2Model() {
        return new Test2Model();
    }
}
