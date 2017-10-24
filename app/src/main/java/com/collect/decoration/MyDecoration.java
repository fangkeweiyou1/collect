package com.collect.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.collect.model.Test12Model;

import timber.log.Timber;

/**
 * Created by zhangyuncai on 2017/10/22.
 */

public class MyDecoration extends DividerItemDecoration {
    public MyDecoration(Context context, int orientation) {
        super(context, orientation);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getChildCount();
        Timber.d("----------->>>>>>>>-----------childCount=" + childCount);
        Object tag = null;
        Object tagNext = null;
        for (int i = 0; i < childCount; i++) {

            tag = parent.getChildAt(i).getTag();


            if ((tag != null && tag instanceof Test12Model) || (tagNext != null && tagNext instanceof Test12Model)) {
                outRect.set(0, 0, 0, 0);
            } else {
                super.getItemOffsets(outRect, view, parent, state);
            }

//            if (tag != null && tag instanceof Test12Model) {
//                outRect.set(0, 0, 0, 0);
//            } else {
//                if (i != (childCount - 1)) {
//                    Object tagNext = parent.getChildAt(i + 1).getTag();
//                    Timber.d("----------->>>>>>>>-----------获取下一个");
//                    if (tagNext != null && tagNext instanceof Test12Model) {
//                        Timber.d("----------->>>>>>>>-----------下一个也符号要求");
//                        outRect.set(0, 0, 0, 0);
//                    } else {
//                        Timber.d("----------->>>>>>>>-----------下一个不符号要求");
//                        super.getItemOffsets(outRect, view, parent, state);
//                    }
//
//                } else {
//                    Timber.d("----------->>>>>>>>-----------这是最后一个");
//                    super.getItemOffsets(outRect, view, parent, state);
//                }
//            }

//            Object tag = layoutManager.getChildAt(i + 1).getTag();
//            if (tag instanceof Test12Model) {
//                Timber.d("----------->>>>>>>>-----------test12");
//                outRect.set(0, 0, 0, 0);
//            } else {
//                super.getItemOffsets(outRect, view, parent, state);
//            }
        }
    }
}
