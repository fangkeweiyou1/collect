package com.collect.dagger.component;

import android.app.Application;

import com.collect.dagger.module.ApplicationModule;
import com.collect.dagger.module.NetWorkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by zhangyuncai on 2017/11/6.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetWorkModule.class})
public interface ApplicationComponent {

    void inject(Application application);

    Application application();

    Retrofit retrofit();
}
