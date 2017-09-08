package com.collect.test;

import java.util.List;

/**
 * Created by zhangyuncai on 2017/8/17.
 */

public class TestHelper {
    TestCallBack testCallBack;

    public void addName(List<String> list, TestCallBack testCallBack) {
        list.add("3");
    }

    public void addInt(TestCallBack testCallBack, int... ints) {
        this.testCallBack = testCallBack;
        for (int anInt : ints) {
            switch (anInt) {
                case 1: {
                    testCallBack.show1();
                    break;
                }
                case 2: {
                    testCallBack.show2();
                    break;
                }
                case 3: {
                    testCallBack.show3();
                    break;
                }
            }
        }


    }

    static class TestCallBack {
        public void show1() {
        }

        public void show2() {
        }

        public void show3() {
        }
    }
}
