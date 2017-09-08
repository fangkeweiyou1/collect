package com.mouse.service;

import com.servicelib.callback.Module;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class MouseModule extends Module<MouseService> {
    @Override
    public void init() {
        serviceInterface = new MouseService();
    }
}
