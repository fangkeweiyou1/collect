package com.collect.model;

import java.util.Set;

/**
 * Created by zhangyuncai on 2017/9/23.
 */

public abstract class PickerBaseModel {
    public int index;
    public String name;

    public abstract Set<Integer> getAlist();

    public abstract Set<Integer> getBlist();

    public abstract Set<Integer> getClist();

    public abstract Set<Integer> getDlist();

}
