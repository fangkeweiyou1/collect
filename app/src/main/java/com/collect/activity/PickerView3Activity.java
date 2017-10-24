package com.collect.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.collect.R;
import com.collect.base.BaseActivity;

import java.util.Calendar;
import java.util.Date;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/9/20.
 * 时间选择器
 */
@RouterMap("activity://pickerview3")
public class PickerView3Activity extends BaseActivity {

    private TimePickerView timePickerView;
    private TextView tv_selecttime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pickerview3);
        tv_selecttime = (TextView) findViewById(R.id.tv_selecttime);

        initView2();

        initData2();

        initEvent2();
    }

    @Override
    protected void initData2() {
        super.initData2();
    }

    @Override
    protected void initView2() {
        initTimePicker();
    }

    @Override
    protected void initEvent2() {
        tv_selecttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timePickerView != null) {
                    timePickerView.show();
                }
            }
        });
    }

    private void initTimePicker() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        TimePickerView.Builder builder = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {

            }
        });

        //设置年月日时分秒的显示与否 false:不显示
        builder = builder.setType(new boolean[]{true, true, true, false, false, false});

        //设置显示中间的label的文字
        builder = builder.setLabel("Y", "M", "D", "", "", "");

        //设置时间数字后缀是否跟着年月日时分秒文字(是否只显示中间的label),没有必要显示,丑,false:显示
        builder = builder.isCenterLabel(false);

        //设置位置
        builder = builder.gravity(Gravity.CENTER);//如果设置年月日时分秒这里只能设置居中,否则文字显示越界(不设置就是默认居中效果)

        //设置选择器选中那一行的上下分割线颜色
        builder = builder.setDividerColor(Color.RED);

        //设置选中时间(默认是当前时间)
        builder = builder.setDate(calendar);

        //设置允许选择的时间范围,最好是用setRange这个API
        builder = builder.setRange(2000, 2020);
//        builder=builder.setRangDate(startCalendar,endCalendar);

        //设置弹出dialog后,背后的阴影颜色
//        builder=builder.setBackgroundId(0x33FF0000);

        //设置依附于那个控件之上弹出来的(默认是当前activity)
        builder = builder.setDecorView(null);

        //设置弹出窗口内部的背景颜色
//        builder=builder.setBgColor(Color.parseColor("#30ff0000"));

        //设置选择时间是否首尾循环,true:循环
//        builder=builder.isCyclic(true);

        //设置弹出窗口是否是对话框模式(从屏幕中间弹出来),true:是弹出窗口,false:从底部弹出来
//        builder=builder.isDialog(true);

        //设置标题
        builder = builder.setTitleText("这是title");

        //设置取消文字
        builder = builder.setCancelText("quxiao");

        //设置确定文字
        builder = builder.setSubmitText("提交");

        //设置内容文字大小
        builder = builder.setContentSize(14);

        //设置外部是否能点击取消dialog false:不能点击
        builder = builder.setOutSideCancelable(false);


        timePickerView = builder.build();
    }

}
