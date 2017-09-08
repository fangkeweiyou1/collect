package com.servicelib.byreflect;

import java.lang.reflect.Constructor;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class BaseReflectModelManager {
    public static BaseReflectModel getBaseReflectModel(String className) throws Exception {
        BaseReflectModel model = null;
        Class<?> aClass = Class.forName(className);
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        if (o instanceof BaseReflectModel) {
            model = (BaseReflectModel) o;
        }

        return model;
    }
}
