//package com.collect.service;
//
//import android.app.Service;
//import android.content.Intent;
//import android.os.IBinder;
//import android.os.SystemClock;
//import android.support.annotation.Nullable;
//
///**
// * Created by zhangyuncai on 2017/8/3.
// */
//
//public class BackgroudService extends Service {
//    boolean isFinishService = false;
//
//    @Nullable
//    @Override
//    public IBinder onBind(Intent intent) {
//        return null;
//    }
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        isFinishService = false;
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//
//        /**
//         * TODO 子线程并不会随着服务关闭而结束,需要手动结束
//         */
//        new Thread() {
//            @Override
//            public void run() {
//                for (; ; ) {
//                    SystemClock.sleep(1000);
//                    if (!isFinishService) {
//                        break;
//                    }
//                }
//            }
//        }.start();
//
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//    @Override
//    public void onDestroy() {
//        isFinishService = true;
//        super.onDestroy();
//    }
//}
