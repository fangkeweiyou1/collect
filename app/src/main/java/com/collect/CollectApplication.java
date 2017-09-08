package com.collect;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.collect.component.BaseComponent;
import com.collect.component.DaggerBaseComponent;
import com.collect.module.BaseModule;
import com.collect.service.InitializeService;
import com.collect.utils.Timber;
import com.utils.ToastUtils;

import cn.campusapp.router.Router;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class CollectApplication extends Application {
    private static Context mContext;
    private static Handler mHandler;
    private static long mMianThreadId;
    private BaseComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
//            Timber.plant(new Timber.DebugTree());
            Timber.plant(new Timber.DebugTree());

        }

        mContext = getApplicationContext();

        mHandler = new Handler();

        mMianThreadId = android.os.Process.myTid();


        Router.initActivityRouter(mContext);

        ToastUtils.application = this;

        InitializeService.start(this.getApplicationContext());

        baseComponent = DaggerBaseComponent.builder().baseModule(new BaseModule()).build();


//        Router.initActivityRouter(mContext, new IActivityRouteTableInitializer() {
//            @Override
//            public void initRouterTable(Map<String, Class<? extends Activity>> map) {
//                ARouterInitHelper.initActivity(map);
//                BRouterInitHelper.initActivity(map);
//            }
//        });
    }

    public BaseComponent getBaseComponent() {
        return baseComponent;
    }

    /**
     * 得到上下文
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * 得到主线程handle
     *
     * @return
     */
    public static Handler getHandler() {
        return mHandler;
    }

    /**
     * 得到主线程id
     *
     * @return
     */
    public static long getMainThreadId() {
        return mMianThreadId;
    }
}
