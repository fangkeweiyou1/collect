package com.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangyuncai on 2017/8/12.
 */

public class View4 extends View {
    public View4(Context context) {
        super(context);
    }

    public View4(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View4(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);

        System.out.println("-----------------<<<>>>--------------------mode="+mode);
        System.out.println("-----------------<<<>>>--------------------size="+size);

    }
}
