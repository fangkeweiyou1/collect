package com.collect.model;

import java.util.Set;

/**
 * Created by zhangyuncai on 2017/9/23.
 */

public class PickerB extends PickerBaseModel{
    public Set<Integer> aList;
    public Set<Integer> cList;
    public Set<Integer> dList;

    @Override
    public Set<Integer> getAlist() {
        return aList;
    }

    @Override
    public Set<Integer> getBlist() {
        return null;
    }

    @Override
    public Set<Integer> getClist() {
        return cList;
    }

    @Override
    public Set<Integer> getDlist() {
        return dList;
    }
}
