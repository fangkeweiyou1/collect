package com.openimdemo;

import android.app.Application;

import com.alibaba.mobileim.channel.IMChannel;
import com.alibaba.wxlib.util.SysUtil;

/**
 * Created by zhangyuncai on 2017/9/12.
 */

public class MyApplication extends Application {
    // 应用APPKEY，这个APPKEY是申请应用时获取的
    public static String APP_KEY = "23015524";
    @Override
    public void onCreate() {
        super.onCreate();

        mustRunFirstInsideApplicationOnCreate(this);
    }

    /**
     * 返回结果是是否已经初始化
     *
     * @param application
     * @return
     */
    public static void mustRunFirstInsideApplicationOnCreate(Application application) {
        //必须的初始化
        //todo Application.onCreate中，首先执行这部分代码，以下代码固定在此处，不要改动，这里return是为了退出Application.onCreate！！！
        SysUtil.setApplication(application);
        boolean tcmsServiceProcess = SysUtil.isTCMSServiceProcess(application.getApplicationContext());
        if (!tcmsServiceProcess) {//todo 如果在":TCMSSevice"进程中，无需进行openIM和app业务的初始化，以节省内存
//            initOpenIM(application);
            LoginSampleHelper.getInstance().initSDK_Sample(application);
        }
    }

    /**
     * 初始化OpenIM
     */
    public static void initOpenIM(Application application) {
        IMChannel.DEBUG = false;
        //初始化云旺SDK
//        try {
//
//            initYWSDK(application);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
