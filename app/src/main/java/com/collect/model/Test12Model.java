package com.collect.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by zhangyuncai on 2017/10/22.
 */

public class Test12Model implements MultiItemEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getItemType() {
        return 12;
    }
}
