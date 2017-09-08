package com.servicelib.callback;

import java.lang.reflect.Constructor;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class ModuleManager {
    public static Module loadModule(String className) throws Exception {
        Module module = null;
        Class<?> aClass = Class.forName(className);
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        if (o instanceof Module) {
            module = (Module) o;
        }
        return module;
    }
}
