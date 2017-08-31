package com.customview;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by zhangyuncai on 2017/8/16.
 */

public class View3Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_child;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view3);

        RelativeLayout rl_parent = (RelativeLayout) findViewById(R.id.rl_parent);
        tv_child = (TextView) findViewById(R.id.tv_child);


        tv_child.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                /**
                 * TODO Left，Right，top,Bottom；它们表示的并非是距离屏幕左上方的绝对值，而是表示 view 和 他的
                 * 父控件的相对坐标值，并且代表View的初始坐标，在绘制完毕后就不会再改变 。
                 */
//                int left = tv_child.getLeft();
//                int top = tv_child.getTop();
//                int right = tv_child.getRight();
//                int bottom = tv_child.getBottom();
//                System.out.println("-----------------<<<>>>--------------------left="+left);
//                System.out.println("-----------------<<<>>>--------------------top="+top);
//                System.out.println("-----------------<<<>>>--------------------right="+right);
//                System.out.println("-----------------<<<>>>--------------------bottom="+bottom);

                /**
                 * TODO X和Y 表示的是View左上角相对于父控件的坐标值，即实时相对坐标
                 */
//                float x = tv_child.getX();
//                float y = tv_child.getY();
//                System.out.println("-----------------<<<>>>--------------------x="+x);
//                System.out.println("-----------------<<<>>>--------------------y="+y);

                /**
                 * TranslationX,TranslationY 这2个值 默认都为0，表示的是相对于父控件的左上角的偏移量。
                 */
//                float translationX = tv_child.getTranslationX();
//                float translationY = tv_child.getTranslationY();
//                System.out.println("-----------------<<<>>>--------------------translationX=" + translationX);
//                System.out.println("-----------------<<<>>>--------------------translationY=" + translationY);


                tv_child.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

//        tv_child.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    System.out.println("-----------------<<<>>>--------------------MOVE");
//                    view.setX(motionEvent.getRawX() - view.getWidth() / 2);
//                    view.setY(motionEvent.getRawY() - view.getHeight() / 2);
//                }
//                    return true;
//            }
//        });

        tv_child.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
    }

//    boolean messre;
//
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//
//        if (hasFocus && !messre) {
//            int width = tv_child.getMeasuredWidth();
//            int height = tv_child.getHeight();
//            System.out.println("-----------------<<<>>>--------------------width=" + width);
//            System.out.println("-----------------<<<>>>--------------------height=" + height);
//            messre=true;
//        }
//    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//        tv_child.post(new Runnable() {
//            @Override
//            public void run() {
//                int width = tv_child.getMeasuredWidth();
//                int height = tv_child.getHeight();
//                System.out.println("-----------------<<<>>>--------------------onResumewidth=" + width);
//                System.out.println("-----------------<<<>>>--------------------onResumeheight=" + height);
//            }
//        });
//    }
}
