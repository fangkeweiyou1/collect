package com.servicelib.callback;

import android.text.TextUtils;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public abstract class Proxy<C> {
    private static final String TAG = "Proxy";

    private Module<C> proxy;

    public abstract String getModuleClassName();

    public abstract Module<C> getDefaultModule();


    public C getServiceInterface() {
        if (getProxy() == null) {
            return null;
        }
        return getProxy().getServiceInterface();
    }

    protected Module<C> getProxy() {
        if (proxy == null) {
            String moduleClassName = getModuleClassName();
            if (!TextUtils.isEmpty(moduleClassName)) {
                try {
                    proxy = ModuleManager.loadModule(moduleClassName);

                } catch (Exception e) {
                    e.printStackTrace();
                    proxy = getDefaultModule();
                }
            }
        }
        if (proxy != null) {
            proxy.init();
        }
        return proxy;
    }
}
