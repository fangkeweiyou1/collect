package com.collect.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.utils.ImageLoadUtils;

/**
 * Created by zhangyuncai on 2017/8/4.
 */

public class InitializeService extends IntentService {
    public InitializeService() {
        super("InitializeService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("-----------------<<<>>>--------------------初始化图片框架");
        ImageLoadUtils.initOptions(this.getApplicationContext());
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, InitializeService.class);
        intent.setAction("InitializeService");
        context.startService(intent);
    }
}
