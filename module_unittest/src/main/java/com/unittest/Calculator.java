package com.unittest;

/**
 * Created by zhangyuncai on 2017/9/10.
 */

public class Calculator {
    public int add(int one, int two) {
        return one + two;
    }

    public float addFloat(float one, float two) {
        return one + two;
    }

    public boolean isComputerName(String name) {
        return true;
    }

    public double divide(double one, double two) {
        if (two == 0) {
            throw new IllegalArgumentException("被除数是0啊!");
        }
        return one / two;
    }
}
