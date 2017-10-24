package com.collect.model;

import java.util.Set;

/**
 * Created by zhangyuncai on 2017/9/23.
 */

public class PickerC extends PickerBaseModel{
    public Set<Integer> bList;
    public Set<Integer> aList;
    public Set<Integer> dList;

    @Override
    public Set<Integer> getAlist() {
        return aList;
    }

    @Override
    public Set<Integer> getBlist() {
        return bList;
    }

    @Override
    public Set<Integer> getClist() {
        return null;
    }

    @Override
    public Set<Integer> getDlist() {
        return dList;
    }
}
