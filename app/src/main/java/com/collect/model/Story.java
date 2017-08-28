package com.collect.model;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zhangyuncai on 2017/8/24.
 */
@AutoValue
public abstract class Story {

    @SerializedName("id")
    public abstract int id();

    @Nullable
    @SerializedName("name")
    public abstract String name();

    public static Story create() {
        return new AutoValue_Story(10, "你好");
    }
}
