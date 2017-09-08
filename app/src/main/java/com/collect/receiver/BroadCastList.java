//package com.collect.receiver;
//
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//
///**
// * Created by zhangyuncai on 2017/8/2.
// * 讲解广播接收者的知识点
// */
//
///**
// * TODO  Intent intent = new Intent();
// * intent.setAction("broadcasttest");
// * sendBroadcast(intent);//这样是发送普通广播,但是接受者仍然按照priority来顺序接收
// * sendOrderedBroadcast(intent,null);//这个是有序广播
// * 以上广播都是所有应用可以收到的
// * LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent().setAction("broadcasttest"));//这个只有本地应用才能收到广播
// *
// * 常用的广播action属性有
// 屏幕被关闭之后的广播：Intent.ACTION_SCREEN_OFF
// 屏幕被打开之后的广播：Intent.ACTION_SCREEN_ON
// 充电状态，或者电池的电量发生变化：Intent.ACTION_BATTERY_CHANGED
// 关闭或打开飞行模式时的广播：Intent.ACTION_AIRPLANE_MODE_CHANGED
// 表示电池电量低：Intent.ACTION_BATTERY_LOW
// 表示电池电量充足，即电池电量饱满时会发出广播：Intent.ACTION_BATTERY_OKAY
// 按下照相时的拍照按键(硬件按键)时发出的广播：Intent.ACTION_CAMERA_BUTTON
// */
//
//public class BroadCastList {
//    public static class BroadCastTest1 extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//        }
//    }
//
//    public static class BroadCastTest2 extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Bundle resultExtras = getResultExtras(true);
//            String content3 = resultExtras.getString("content3");
//            abortBroadcast();//可以拦截广播
//        }
//    }
//
//    public static class BroadCastTest3 extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            Bundle bundle = new Bundle();
//            bundle.putString("content3", "内容3");
//            setResultExtras(bundle);//可以重新设置广播内容
//        }
//    }
//}
