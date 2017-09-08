package com.mouse.reflect;

import com.servicelib.byreflect.BaseReflectModel;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class MouseModel extends BaseReflectModel {
    private String name;
    private int age;

    {
        name = "勇敢是什么";
        age = 101;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
