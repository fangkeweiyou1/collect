package com.module_b;

import android.app.Activity;

import java.util.Map;

/**
 * Created by zhangyuncai on 2017/8/18.
 */

public class BRouterInitHelper {
    /**
     * Router 注册
     *
     */
    public static void initActivity(Map<String, Class<? extends Activity>> router) {
        router.put("activity://btest", BTestActivity.class);
    }
}
