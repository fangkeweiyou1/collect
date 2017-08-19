package com.module_a;

import android.app.Activity;

import java.util.Map;

/**
 * Created by zhangyuncai on 2017/8/18.
 */

public class ARouterInitHelper {
    /**
     * Router 注册
     *
     */
    public static void initActivity(Map<String, Class<? extends Activity>> router) {
        router.put("activity://atest", ATestActivity.class);
    }
}
