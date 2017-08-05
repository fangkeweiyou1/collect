package com.collect.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.collect.R;
import com.collect.base.BaseActivity;
import com.utils.DisPlayUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/8/2.
 * 学习View
 */
@RouterMap({"activity://view"})
public class ViewActivity extends BaseActivity {
    @BindView(R.id.tv_childview)
    TextView tv_childview;
    @BindView(R.id.ll_layout)
    LinearLayout ll_layout;
    @BindView(R.id.rl_layout)
    RelativeLayout rl_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);

        getChildView();
    }

    Handler mHandler = new Handler();

    /**
     * 获取子控件在父控件中的坐标
     *
     *
     */
    private void getChildView() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /*
              TODO  Left，Right，top,Bottom；它们表示的并非是距离屏幕左上方的绝对值，而是表示 view(该view左上右下) 和
                他的父控件(左上角的点的坐标)的相对坐标值，并且代表View的初始坐标，在绘制完毕后就不会再改变
                 */
//                int left = tv_childview.getLeft();
//                int top = tv_childview.getTop();
//                int right = tv_childview.getRight();
//                int bottom = tv_childview.getBottom();
//                left = px2dip(left);
//                top = px2dip(top);
//                right = px2dip(right);
//                bottom = px2dip(bottom);
//                System.out.println("-----------------<<<>>>--------------------left=" + left);
//                System.out.println("-----------------<<<>>>--------------------top=" + top);
//                System.out.println("-----------------<<<>>>--------------------right=" + right);
//                System.out.println("-----------------<<<>>>--------------------bottom=" + bottom);

                /*
                TODO X和Y 表示的是View左上角相对于父控件的坐标值，即实时相对坐标。
                 */
                float x = tv_childview.getX();
                float y = tv_childview.getY();
                x = DisPlayUtils.px2dip(x);
                y = DisPlayUtils.px2dip(y);
                System.out.println("-----------------<<<>>>--------------------x=" + x);
                System.out.println("-----------------<<<>>>--------------------y=" + y);

                /*
                TODO TranslationX,TranslationY 这2个值 默认都为0，表示的是相对于父控件的左上角的偏移量
                 */

                /*
                x=left+translationX;
                y=top+translationY;
                width = right-left;
                height = bottom-top;
                left = getLeft();
                 */
            }
        }, 200);
    }
}
