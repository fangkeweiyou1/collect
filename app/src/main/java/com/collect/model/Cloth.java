package com.collect.model;

import com.collect.base.BaseModel;

/**
 * Created by zhangyuncai on 2017/8/5.
 */

public class Cloth extends BaseModel {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + "布料";
    }

}
