package com.javasdudy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by zhangyuncai on 2017/7/27.
 */

public class MyBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("-----------------<<<>>>--------------------收到");
//        Intent intent1 = new Intent(context, JavaStudyActivity.class);
//        Intent intent1 = new Intent(context, InternetActivity.class);
        Intent intent1 = new Intent(context, RegexActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
