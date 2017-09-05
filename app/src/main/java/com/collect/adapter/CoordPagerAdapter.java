package com.collect.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.collect.fragment.CoordFragment;

/**
 * Created by zhangyuncai on 2017/9/4.
 */

public class CoordPagerAdapter extends FragmentPagerAdapter {

    public CoordPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return CoordFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.format("这是第%d页", position);
    }
}
