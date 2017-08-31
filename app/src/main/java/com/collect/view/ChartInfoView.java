package com.collect.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.collect.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangyuncai on 2017/8/28.
 */

public class ChartInfoView extends LinearLayout {
    @BindView(R.id.linechart)
    LineChart mChart;
    private LayoutInflater mLayoutInflater;

    public ChartInfoView(Context context) {
        super(context);

        init();
    }

    public ChartInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public ChartInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mLayoutInflater = LayoutInflater.from(getContext());
        mLayoutInflater.inflate(R.layout.view_chartinfo, this);

        ButterKnife.bind(this);

        initView();

        initEvent();
    }

    private void initView() {
        initLineChart();

    }

    private void initEvent() {

    }

    private void initLineChart() {
        mChart.setDrawGridBackground(false);

        // no description text
//        Description description = new Description();
//        description.setText("这是图表描述");
//        mChart.setDescription(description);
        mChart.getDescription().setEnabled(false);//false:隐藏图表描述

        // enable touch gestures
        mChart.setTouchEnabled(true);//false:禁用手势

        // enable scaling and dragging
        mChart.setDragEnabled(false);//false:不能拖动图表
        mChart.setScaleEnabled(false);//false:不能缩放图表
        // mChart.setScaleXEnabled(true);
        // mChart.setScaleYEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(false);//false:不能双击放大

        // set an alternative background color
        // mChart.setBackgroundColor(Color.GRAY);

        // create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it
//        MyMarkerView mv = new MyMarkerView(getContext(), R.layout.custom_marker_view);
//        mv.setChartView(mChart); // For bounds control
//        mChart.setMarker(mv); // Set the marker to the chart

        // x-axis limit line
        //X轴限制线
//        LimitLine llXAxis = new LimitLine(10f, "Index 10");
//        llXAxis.setLineWidth(4f);
//        llXAxis.enableDashedLine(10f, 10f, 0f);
//        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
//        llXAxis.setTextSize(10f);

        XAxis xAxis = mChart.getXAxis();
//        xAxis.enableGridDashedLine(0f, 0f, 0f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//X轴显示的位置
        xAxis.setDrawGridLines(false);//设置隐藏网格线
        xAxis.setAxisLineWidth(1.5f);//设置X轴的宽度
        xAxis.setAxisLineColor(Color.WHITE);//设置X轴的颜色
        xAxis.setTextColor(Color.WHITE);//设置X轴文字的颜色
        //xAxis.setValueFormatter(new MyCustomXAxisValueFormatter());
//        xAxis.addLimitLine(llXAxis); // add x-axis limit line



//        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "OpenSans-Regular.ttf");

//        LimitLine ll1 = new LimitLine(150f, "Upper Limit");
//        ll1.setLineWidth(4f);
//        ll1.enableDashedLine(10f, 10f, 0f);
//        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
//        ll1.setTextSize(10f);
////        ll1.setTypeface(tf);
//
//        LimitLine ll2 = new LimitLine(-30f, "Lower Limit");
//        ll2.setLineWidth(4f);
//        ll2.enableDashedLine(10f, 10f, 0f);
//        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
//        ll2.setTextSize(10f);
//        ll2.setTypeface(tf);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
//        leftAxis.addLimitLine(ll1);
//        leftAxis.addLimitLine(ll2);
//        leftAxis.setAxisMaximum(4500);
        leftAxis.setAxisMinimum(0);
        //leftAxis.setYOffset(20f);
        leftAxis.setDrawZeroLine(true);
        leftAxis.setAxisLineWidth(0.5f);//设置Y轴的宽度
        leftAxis.setAxisLineColor(Color.WHITE);//设置Y轴的颜色
        leftAxis.setTextColor(Color.WHITE);//设置Y轴文字的颜色
        leftAxis.enableGridDashedLine(0f, 0f, 0f);//设置网格线Y轴方向线虚线形式
        leftAxis.setGridLineWidth(0.5f);//设置网格线Y轴方向线的宽度
        leftAxis.setGridColor(Color.parseColor("#70ffffff"));
        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);
//        DashPathEffect dashPathEffect=new DashPathEffect(new float[]{10f,20f,30f},10f);
//        leftAxis.setGridDashedLine(dashPathEffect);////设置网格线Y轴方向线虚线形式


        mChart.getAxisRight().setEnabled(false);

        //mChart.getViewPortHandler().setMaximumScaleY(2f);
        //mChart.getViewPortHandler().setMaximumScaleX(2f);

        // add data
        setData(45, 100);

//        mChart.setVisibleXRange(20);
//        mChart.setVisibleYRange(20f, AxisDependency.LEFT);
//        mChart.centerViewTo(20, 50, AxisDependency.LEFT);

//        mChart.animateX(2500);
        //mChart.invalidate();

        // get the legend (only possible after setting data)
        Legend l = mChart.getLegend();

        // modify the legend ...
        l.setForm(Legend.LegendForm.NONE);//设置图表描述点的类型
        l.setTextColor(Color.TRANSPARENT);

        // // dont forget to refresh the drawing
        // mChart.invalidate();
    }

    private static String[] strings = new String[]{"08/01", "08/02", "08/03", "08/04", "08/05", "08/06", "08/07",};

    private void setData(int count, float range) {
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setGranularity(1000f);
        leftAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                if ((int) (value / 1000) == 0) {
                    return "";
                }

                return String.format("%dK", (int) (value / 1000));
            }
        });

        XAxis xAxis = mChart.getXAxis();
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                int i = (int) value;
                if (strings.length > i && i >= 0) {
                    return strings[i];
                }
                return "";
            }
        });

        ArrayList<Entry> values = new ArrayList<Entry>();

//        for (int i = 0; i < count; i++) {
//
//            float val = (float) (Math.random() * range) + 3;
////            values.add(new Entry(i, val, getResources().getDrawable(R.drawable.star)));//图表上的每个点可以增加icon
//            values.add(new Entry(i, val));
//        }


        values.add(new Entry(0, 1000));
        values.add(new Entry(1, 2000));
        values.add(new Entry(2, 3000));
        values.add(new Entry(3, 2400));
        values.add(new Entry(4, 1700));
        values.add(new Entry(5, 1400));
        values.add(new Entry(6, 1500));

        LineDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "DataSet 1");

            set1.setDrawIcons(false);//false:隐藏图标上的每个店的icon

            // set the line to be drawn like this "- - - - - -"
//            set1.enableDashedLine(10f, 5f, 0f);//设置图标上每个点的连接线
            set1.enableDashedLine(0f, 0f, 0f);//设置图标上每个点的连接线
//            set1.enableDashedHighlightLine(10f, 5f, 0f);//设置十字轴的连接线
            set1.enableDashedHighlightLine(0f, 0f, 0f);//设置十字轴的连接线
            set1.setColor(Color.WHITE);//设置连接线的颜色
            set1.setCircleColor(Color.WHITE);//设置点的颜色
            set1.setLineWidth(1f);//设置连接线的宽度
            set1.setCircleRadius(2f);//设置点的半径
            set1.setDrawCircleHole(true);
            set1.setValueTextSize(9f);//设置点上的文字大小
            set1.setValueTextColor(Color.WHITE);//设置点上的文字颜色
            set1.setDrawFilled(true);//true:设置连接线与X轴包围圈填充颜色
            set1.setDrawHorizontalHighlightIndicator(false);//设置十字轴不显示横线的那条线
//            set1.setFormLineWidth(1f);
//            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
//            set1.setFormSize(15.f);

            //设置填充区颜色
            if (Utils.getSDKInt() >= 18) {
                // fill drawable only supported on api level 18 and above
                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_red);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.BLACK);
            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData data = new LineData(dataSets);

            // set data
            mChart.setData(data);
        }
    }


}
