package com.collect.module;

import com.collect.model.Student;
import com.collect.model.Teacher;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangyuncai on 2017/8/10.
 */
@Module
public class TestModule {
    @Singleton
    @Provides
    public Teacher getTeacher(Student student) {
        Teacher teacher = new Teacher(student);
        teacher.setName("这是测试");
        student.setName("我是红色");
        return teacher;
    }

    @Singleton
    @Provides
    public Student getStudent() {
        Student student = new Student();
        student.setAge(112);
        return student;
    }

}
