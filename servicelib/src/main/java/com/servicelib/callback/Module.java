package com.servicelib.callback;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public abstract class Module<C> {
    protected C serviceInterface;

    public C getServiceInterface() {
        return serviceInterface;
    }

    public abstract void init();
}
