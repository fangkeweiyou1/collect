package com.computer.reflect;

import com.servicelib.byreflect.BaseReflectModel;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class ComputerModel extends BaseReflectModel {
    private String name;
    private int age;

    {
        name = "明天你好";
        age = 100;
    }

    public ComputerModel() {
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
