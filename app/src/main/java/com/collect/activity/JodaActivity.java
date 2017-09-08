//package com.collect.activity;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//
//import com.collect.R;
//import com.collect.base.BaseActivity;
//
//import org.joda.time.DateTime;
//
//import cn.campusapp.router.annotation.RouterMap;
//
///**
// * Created by zhangyuncai on 2017/8/28.
// */
//@RouterMap("activity://joda")
//public class JodaActivity extends BaseActivity {
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_joda);
//
//        DateTime dateTime = new DateTime();
//        String asShortText = dateTime.year().getAsShortText();
//        boolean leap = dateTime.year().isLeap();
//    }
//
//}
