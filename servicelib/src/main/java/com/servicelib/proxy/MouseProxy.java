package com.servicelib.proxy;

import com.servicelib.callback.Module;
import com.servicelib.callback.Proxy;
import com.servicelib.iservice.IMouseService;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class MouseProxy extends Proxy<IMouseService> {
    @Override
    public String getModuleClassName() {
        return "com.mouse.service.MouseModule";
    }

    @Override
    public Module<IMouseService> getDefaultModule() {
        return null;
    }
}
