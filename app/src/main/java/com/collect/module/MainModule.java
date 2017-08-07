package com.collect.module;

import com.collect.model.Cloth;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangyuncai on 2017/8/5.
 */
@Module
public class MainModule {
    @Provides
    public Cloth getCloth() {
        Cloth cloth = new Cloth();
        cloth.setColor("红色");
        return cloth;
    }
}
