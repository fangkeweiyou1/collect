package com.servicelib;

import cn.campusapp.router.Router;

/**
 * Created by zhangyuncai on 2017/8/18.
 */

public class RouterInterHelper {
    public static void skipATestActivity() {
        Router.open("activity://atest");
    }

    public static void skipBTestActivity() {
        Router.open("activity://btest");
    }
}
