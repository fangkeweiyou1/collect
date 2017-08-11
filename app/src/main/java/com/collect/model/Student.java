package com.collect.model;

import javax.inject.Inject;

/**
 * Created by zhangyuncai on 2017/8/10.
 */

public class Student {
    private int age;
    private String name;

    @Inject
    public Student() {
        name="我是学生";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
