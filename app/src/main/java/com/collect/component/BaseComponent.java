package com.collect.component;

import com.collect.model.Test2Model;
import com.collect.module.BaseModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zhangyuncai on 2017/8/11.
 */
@Singleton
@Component(modules = BaseModule.class)
public interface BaseComponent {
    Test2Model getTest2Model();
}
