//package com.collect.view;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.view.View;
//
///**
// * Created by zhangyuncai on 2017/8/12.
// */
//
//public class CustomView extends View {
//    public CustomView(Context context) {
//        super(context);
//    }
//
//    public CustomView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int mode = MeasureSpec.getMode(widthMeasureSpec);
//        int size = MeasureSpec.getSize(widthMeasureSpec);
//
//        System.out.println("-----------------<<<>>>--------------------mode="+mode);
//        System.out.println("-----------------<<<>>>--------------------size="+size);
//
//    }
//}
