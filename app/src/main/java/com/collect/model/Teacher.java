package com.collect.model;

import javax.inject.Inject;

/**
 * Created by zhangyuncai on 2017/8/10.
 */

public class Teacher {
    private String name;
    private int age;

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    @Inject
    public Teacher() {
    }


    public void setStudent(Student student) {
        this.student = student;
    }

    @Inject
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
