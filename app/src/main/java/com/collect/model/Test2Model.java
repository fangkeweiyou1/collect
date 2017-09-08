package com.collect.model;

import android.text.TextUtils;

import com.collect.base.BaseModel;

/**
 * Created by zhangyuncai on 2017/7/27.
 */

public class Test2Model extends BaseModel {
    private static Test2Model mTest2Model;
    private String name;
    private String content;
    private String desc;

    public void init() {
        mTest2Model = this;
    }

    public static Test2Model getmTest2Model() {
        return mTest2Model;
    }

    public String getDesc() {
        if (TextUtils.isEmpty(desc))
            return "";
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        if (TextUtils.isEmpty(content))
            return "";
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        if (TextUtils.isEmpty(name))
            return "";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
