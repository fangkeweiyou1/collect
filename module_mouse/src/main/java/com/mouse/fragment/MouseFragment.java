package com.mouse.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mouse.R;

/**
 * Created by zhangyuncai on 2017/9/6.
 */

public class MouseFragment extends Fragment {
    public static Fragment newInstance() {
        return new MouseFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_mouse, null);
        return view;
    }
}
