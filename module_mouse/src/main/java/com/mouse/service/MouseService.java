package com.mouse.service;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.mouse.fragment.MouseFragment;
import com.servicelib.iservice.IMouseService;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class MouseService implements IMouseService {

    @Override
    public Fragment initMouseFragment(Context context) {
        return MouseFragment.newInstance();
    }
}
