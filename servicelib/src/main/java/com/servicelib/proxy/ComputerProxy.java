package com.servicelib.proxy;

import com.servicelib.callback.Module;
import com.servicelib.callback.Proxy;
import com.servicelib.iservice.IComputerService;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class ComputerProxy extends Proxy<IComputerService> {
    @Override
    public String getModuleClassName() {
        return "com.computer.service.ComputerModule";
    }

    @Override
    public Module<IComputerService> getDefaultModule() {
        return null;
    }
}
