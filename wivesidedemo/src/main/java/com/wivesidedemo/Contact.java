package com.wivesidedemo;

import android.text.TextUtils;

/**
 * Created by zhangyuncai on 2017/8/31.
 */

public class Contact {
    private String index;
    private String name;

    public Contact(String index, String name) {
        this.index = index;
        this.name = name;
    }

    public String getIndex() {
        if (TextUtils.isEmpty(index)) {
            return "";
        }
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        if (TextUtils.isEmpty(name)) {
            return "";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "index='" + index + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
