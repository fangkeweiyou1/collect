package com.collect.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by zhangyuncai on 2017/8/2.
 */

public class BroadCastList {
    public static class BroadCastTest1 extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println("-----------------<<<>>>--------------------广播1");
        }
    }

    public static class BroadCastTest2 extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println("-----------------<<<>>>--------------------广播2");

        }
    }

    public static class BroadCastTest3 extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            System.out.println("-----------------<<<>>>--------------------广播3");

        }
    }
}
