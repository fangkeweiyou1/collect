package com.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangyuncai on 2017/7/31.
 * 高级绘制
 */

public class View3 extends View {
    public View3(Context context) {
        super(context);
    }

    public View3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public View3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        drawShader1(canvas);

//        drawShader2(canvas);

        drawShader3(canvas);
    }

    /**
     * TODO:SweepGradient 扫描渐变
     * cx cy ：扫描的中心
     * color0：扫描的起始颜色
     * color1：扫描的终止颜色
     *
     * @param canvas
     */
    private void drawShader3(Canvas canvas) {
        Paint paint = new Paint();

        Shader shader = new SweepGradient(300, 300, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"));
        paint.setShader(shader);

        canvas.drawCircle(300, 300, 200, paint);
    }

    /**
     * centerX centerY：辐射中心的坐标
     * radius：辐射半径
     * centerColor：辐射中心的颜色
     * edgeColor：辐射边缘的颜色
     * tileMode：辐射范围之外的着色模式。
     *
     * @param canvas
     */
    private void drawShader2(Canvas canvas) {
        Paint paint = new Paint();

        Shader shader = new RadialGradient(300, 300, 200, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint.setShader(shader);
        canvas.drawCircle(300, 300, 200, paint);
    }

    /**
     * TODO: 线性渐变
     * Shader是安卓中的着色器
     *
     * @param canvas
     */
    private void drawShader1(Canvas canvas) {
        Paint paint = new Paint();


        /*
        TODO: 线性渐变
        x0 y0 x1 y1：渐变的两个端点的位置
        color0 color1 是端点的颜色
        tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选： CLAMP, MIRROR 和 REPEAT。CLAMP
        （夹子模式？？？算了这个词我不会翻）会在端点之外延续端点处的颜色；MIRROR 是镜像模式；REPEAT 是重复模式。具体的看一下例子就明白。
         */
        Shader shader = new LinearGradient(100, 300, 500, 300, Color.parseColor("#FF0000"), Color.parseColor("#00FF00"), Shader.TileMode.CLAMP);
        paint.setShader(shader);

        canvas.drawCircle(300, 300, 200, paint);

    }
}
