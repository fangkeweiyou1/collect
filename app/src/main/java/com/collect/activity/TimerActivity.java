//package com.collect.activity;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.widget.TextView;
//
//import com.collect.R;
//import com.collect.base.BaseActivity;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Timer;
//import java.util.TimerTask;
//
//import cn.campusapp.router.annotation.RouterMap;
//
///**
// * Created by zhangyuncai on 2017/8/1.
// * Timer是一个线程安全的单线程的任务调度工具，对于任务的调度有如下几种调度方式
// * a. 当前时间+时延
// * b. 当前时间+时延+任务执行间隔
// * c. 当前时间+时延+任务执行周期
// * d. 指定时间
// * e. 指定时间+时延
// * f. 指定时间+时延+任务执行间隔
// * g. 指定时间+时延+任务执行周期
// */
//@RouterMap({"activity://timer"})
//public class TimerActivity extends BaseActivity {
//
//    private TextView tv_test;
//    private Timer timer;
//    private int i = 0;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_timer);
//
//        tv_test = (TextView) findViewById(R.id.tv_test);
//
//        Calendar calendar=Calendar.getInstance();
//        int i = calendar.get(Calendar.WEEK_OF_YEAR);
//
//        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//        String format = dateFormat.format(calendar.getTime());
//
//        calendar.add(Calendar.MINUTE,1);
//
//        timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                TimerActivity.this.i++;
//                if (TimerActivity.this.i > 5) {
//                    timer.cancel();
//                }
//
//                Calendar calendar=Calendar.getInstance();
//
//                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//                String format = dateFormat.format(calendar.getTime());
//            }
//        };
//
////        timer.schedule(timerTask, calendar.getTime(), 1000);
//    }
//}
