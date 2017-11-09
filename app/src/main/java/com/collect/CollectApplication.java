package com.collect;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.blankj.utilcode.utils.Utils;
import com.collect.dagger.component.ApplicationComponent;
import com.collect.dagger.component.DaggerApplicationComponent;
import com.collect.service.InitializeService;
import com.utils.ToastUtils;

import cn.campusapp.router.Router;
import timber.log.Timber;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class CollectApplication extends Application {
    private static Context mContext;
    private static Handler mHandler;
    private static long mMianThreadId;

    public static final String YOUMENG_APPKEY = "59c8a4cce88bad36b9000043";
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);

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

        applicationComponent = DaggerApplicationComponent.builder().build();
        applicationComponent.inject(this);


//        Router.initActivityRouter(mContext, new IActivityRouteTableInitializer() {
//            @Override
//            public void initRouterTable(Map<String, Class<? extends Activity>> map) {
//                ARouterInitHelper.initActivity(map);
//                BRouterInitHelper.initActivity(map);
//            }
//        });

        /**
         * EScenarioType. E_UM_NORMAL　　普通统计场景类型

         EScenarioType. E_UM_GAME     　　游戏场景类型

         EScenarioType. E_UM_ANALYTICS_OEM  统计盒子场景类型

         EScenarioType. E_UM_GAME_OEM      　 游戏盒子场景类型
         */
//        MobclickAgent.startWithConfigure(UMAnalyticsConfig config)
//        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
//        MobclickAgent.UMAnalyticsConfig umAnalyticsConfig = new MobclickAgent.UMAnalyticsConfig(this, YOUMENG_APPKEY, null, null, true);
    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
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
