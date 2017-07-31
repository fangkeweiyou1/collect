package com.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangyuncai on 2017/7/29.
 * 自定义view1
 * 基本绘制
 */

public class View1 extends View {

//    Paint.setStyle(Style style) 设置绘制模式 FILL 是填充模式，STROKE 是画线模式（即勾边模式），FILL_AND_STROKE 是两种模式一并使用：既画线又填充。它的默认值是 FILL，填充模式
//    Paint.setColor(int color) 设置颜色
//    Paint.setStrokeWidth(float width) 设置线条宽度,在 STROKE 和 FILL_AND_STROKE 下，还可以使用 mPaint.setStrokeWidth(float width) 来设置线条的宽度
//    Paint.setTextSize(float textSize) 设置文字大小
//    Paint.setAntiAlias(boolean aa) 设置抗锯齿开关


    Paint mPaint = new Paint();
//    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//开启抗锯齿

    Path mPath = new Path();


    public View1(Context context) {
        super(context);
    }

    public View1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        drawCircle(canvas);

//        drawRect(canvas);

//        drawPoint(canvas);

//        drawOval(canvas);

//        drawLine(canvas);

//        drawArc(canvas);

        drawPath(canvas);

//        drawBitmap(canvas);

//        drawText(canvas);
    }

    /**
     * 绘制文字
     *
     * @param canvas
     */
    private void drawText(Canvas canvas) {
        String text = "你好世界!";

        mPaint.setTextSize(20);
        mPaint.setColor(Color.RED);
        canvas.drawText(text,50,50,mPaint);

        mPaint.setTextSize(30);
        mPaint.setColor(Color.GREEN);
        canvas.drawText(text,50,100,mPaint);

        mPaint.setTextSize(40);
        mPaint.setColor(Color.BLUE);
        canvas.drawText(text,50,200,mPaint);
    }

    /**
     * 绘制一个Bitmap
     *
     * @param canvas
     */
    private void drawBitmap(Canvas canvas) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        canvas.drawBitmap(bitmap, 100, 100, mPaint);
    }

    /**
     * 绘制自定义路径
     *
     * @param canvas
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawPath(Canvas canvas) {
        /*
        addCircle(float x, float y, float radius, Direction dir) 添加圆
        x, y, radius 这三个参数是圆的基本信息，最后一个参数 dir 是画圆的路径的方向
        CW:顺时针  CCW:逆时针
         */
//        mPath.addCircle(300,300,300, Path.Direction.CCW);
//        mPath.addCircle(400,300,300, Path.Direction.CW);//可以试着跑起来看看,很神奇
        //Path可以添加任何封闭性路径

        /*
        从当前位置向目标位置画一条直线， x 和 y 是目标位置的坐标。这两个方法的区别是，lineTo(x, y) 的参数是绝对坐标
        ，而 rLineTo(x, y) 的参数是相对当前位置的相对坐标 （前缀 r 指的就是  relatively 「相对地」)。
         */


        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.STROKE);//画路径时必须设置划线模式

//        mPath.lineTo(50,50);
//        mPaint.setColor(Color.TRANSPARENT);
//        mPath.moveTo(600,100);
//        mPath.moveTo(700,100);
//        mPath.moveTo(800,100);
//点点滴滴
        /*
        一个叫 arcTo ，一个叫 addArc()，都是弧形，区别在哪里？其实很简单：  addArc() 只是一个直接使用了 forceMoveTo = true 的简化版 arcTo()
         */
//        mPath.arcTo(100, 100, 300, 300, -90, 90, true); // 强制移动到弧形起点（无痕迹）
//        mPaint.setColor(Color.RED);
//        mPath.lineTo(600,300);


        mPath.lineTo(200, 100);
        mPath.moveTo(300, 0);
        mPath.lineTo(300, 300);
//        mPath.close();
//        mPath.moveTo(500,0);
//        mPath.lineTo(500,500);
//        mPath.close(); // 使用 close() 封闭子图形。等价于 path.lineTo(100, 100),TODO:close() 和 lineTo(起点坐标) 是完全等价的

        canvas.drawPath(mPath, mPaint);
    }

    /**
     * 绘制弧形
     * drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；startAngle 是弧形
     * 的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），sweepAngle 是弧形划过的角度
     * ；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形
     *
     * @param canvas
     */
    private void drawArc(Canvas canvas) {
        int left = 100;
        int top = 100;
        int right = 300;
        int bottom = 500;

        RectF rectF = new RectF(left, top, right, bottom);

        float startAngle = 0;//起始弧度
        float sweepAngle = 260;//顺时针扫略弧度
        boolean useCenter = false;//是否连接圆心

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);

        canvas.drawArc(rectF, startAngle, sweepAngle, useCenter, mPaint);

    }

    /**
     * 绘制直线
     *
     * @param canvas
     */
    private void drawLine(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(20);
        mPaint.setAntiAlias(true);

//        canvas.drawLine(50, 50, 350, 200, mPaint);

        float[] points = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120, 150, 20, 250, 20, 150, 20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
        canvas.drawLines(points, mPaint);
    }


    /**
     * 绘制一个基本圆
     * <p>
     * TODO:每个View的坐标原点都是该控件左上点
     * <p>
     * TODO:Paint只存储公有信息,譬如颜色,文字大小等,不会储存控件坐标等独有信息
     * 圆心坐标和半径，这些都是圆的基本信息，也是它的独有信息。什么叫独有信息？就是只有它有，别人没有的信息。你画圆有圆心坐标和半径，画方有吗？画椭圆有吗？这就叫独有信息。独有信息都是直接作为参数写进 drawXXX() 方法里的（比如 drawCircle(centerX, centerY, radius, mPaint) 的前三个参数）。
     * 而除此之外，其他的都是公有信息。比如图形的颜色、空心实心这些，你不管是画圆还是画方都有可能用到的，这些信息则是统一放在 mPaint 参数里的。
     *
     * @param canvas
     */
    private void drawCircle(Canvas canvas) {


        mPaint.setColor(Color.RED);//设置画笔颜色
//        mPaint.setStyle(Paint.Style.STROKE);//把绘制模式改为画线模式(俗称空心圆)
//        mPaint.setStrokeWidth(10);//在 STROKE 和 FILL_AND_STROKE 下，还可以使用 mPaint.setStrokeWidth(float width) 来设置线条的宽度
        mPaint.setAntiAlias(true);//设置抗锯齿开关

        /*
        4个参数,前两个是设置坐标,第三个设置圆的半径,第四个是笔,参数单位都是 TODO 像素
        坐标都要从该控件左上角原点坐标开始
         */
        canvas.drawCircle(300, 300, 200, mPaint);


//        canvas.drawColor(Color.RED);//设置画布颜色(并不是设置底色,因为设置过后,画布上的其他图案就被遮掩了)
//        canvas.drawRGB(0,255,0);//这个也是设置颜色
//        canvas.drawARGB(51,0,255,0);//这个也是设置颜色
        canvas.drawColor(Color.parseColor("#3300ff00"));//会在原有的绘制效果上加一层半透明的红色遮罩
    }

    /**
     * 绘制一个基本矩形
     *
     * @param canvas
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawRect(Canvas canvas) {
        mPaint.setColor(Color.RED);//设置画笔颜色

//        canvas.drawRect(100,100,300,300, mPaint);//参数单位都是 TODO 像素

//        mPaint.setColor(Color.BLUE);
//        RectF rectF=new RectF(100,100,300,300);
//        canvas.drawRect(rectF,mPaint);

//        mPaint.setColor(Color.GREEN);
//        Rect rect = new Rect(100, 100, 300, 300);
//        canvas.drawRect(rect, mPaint);

        mPaint.setColor(Color.RED);
        canvas.drawRoundRect(100, 100, 300, 300, 50, 50, mPaint);//left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径
        //重载方法drawRoundRect(RectF rect, float rx, float ry, Paint paint)

    }

    /**
     * 绘制一个点,和drawCircle有时候的表现形式完全一样
     * <p>
     * x 和 y 是点的坐标。点的大小可以通过 paint.setStrokeWidth(width) 来设置；点的形状可以通过  paint.setStrokeCap(cap) 来设置：ROUND 画出来是圆形的点，SQUARE 或 BUTT 画出来是方形的点。
     *
     * @param canvas
     */
    private void drawPoint(Canvas canvas) {

        mPaint.setStrokeWidth(50);
        mPaint.setColor(Color.parseColor("#33ff0000"));
        mPaint.setStrokeCap(Paint.Cap.ROUND);//设置圆形点,TODO Paint.setStrokeCap(cap) 可以设置点的形状，但这个方法并不是专门用来设置点的形状的，而是一个设置线条端点形状的方法。端点有圆头 (ROUND)、平头 (BUTT) 和方头 (SQUARE) 三种

//        canvas.drawPoint(300, 300, mPaint);

        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
//        canvas.drawPoints(points,mPaint);
        //offset 表示跳过数组的前几个数再开始记坐标；count 表示一共要绘制几个点
        canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
                8 /* 一共绘制 8 个数（4 个点）*/, mPaint);
    }

    /**
     * 绘制椭圆
     * left, top, right, bottom 是这个椭圆的左、上、右、下四个边界点的坐标
     *
     * @param canvas
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawOval(Canvas canvas) {
        mPaint.setColor(Color.parseColor("#33ff0000"));
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawOval(50, 50, 350, 200, mPaint);
        //重载方法 drawOval(RectF rect, Paint paint)
    }


}
