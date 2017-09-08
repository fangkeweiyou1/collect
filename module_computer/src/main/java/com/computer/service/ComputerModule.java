package com.computer.service;

import com.servicelib.callback.Module;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class ComputerModule extends Module<ComputerService> {
    @Override
    public void init() {
        serviceInterface=new ComputerService();
    }
}
