//package com.collect.utils;
//
//import android.content.Context;
//import android.content.pm.PackageInfo;
//import android.content.pm.PackageManager;
//
///**
// * Created by zhangyuncai on 2017/8/17.
// */
//
//public class UpdateAppUtil {
//    public static int getAppLocalVersion(Context context) {
//        int currentVersionCode = 0;
//        PackageManager packageManager = context.getPackageManager();
//        try {
//            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
//            int versionCode = packageInfo.versionCode;
//            currentVersionCode = versionCode;
//            String versionName = packageInfo.versionName;
//            System.out.println("-----------------<<<>>>--------------------versionCode=" + versionCode);
//            System.out.println("-----------------<<<>>>--------------------versionName=" + versionName);
//
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return currentVersionCode;
//    }
//}
