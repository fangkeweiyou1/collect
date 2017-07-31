package com.customview;

import android.content.Context;
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
 * Created by zhangyuncai on 2017/7/31.
 * 用来练习的
 */

public class View2 extends View {
    Paint mPaint = new Paint();

    public View2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public View2(Context context) {
        super(context);
    }

    public View2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        drawWork1(canvas);

//        drawWork2(canvas);

//        drawWork3(canvas);

//        drawWork4(canvas);

//        drawWork5(canvas);

//        drawWork6(canvas);

//        drawWork7(canvas);

//        drawWork8(canvas);

//        drawWork9(canvas);

        drawWork10(canvas);
    }

    private void drawWork10(Canvas canvas) {
        mPaint.setColor(Color.parseColor("#33ff0000"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);

        RectF rectF=new RectF(200,200,800,800);
        canvas.drawArc(rectF,315,45,true,mPaint);

        mPaint.setColor(Color.parseColor("#99ff0000"));
        canvas.drawArc(rectF,2,5,true,mPaint);

        mPaint.setColor(Color.parseColor("#3300ff00"));
        canvas.drawArc(rectF,8,5,true,mPaint);

        mPaint.setColor(Color.parseColor("#00ff00"));
        canvas.drawArc(rectF,14,50,true,mPaint);

        mPaint.setColor(Color.parseColor("#9900ff00"));
        canvas.drawArc(rectF,55,118,true,mPaint);

        RectF rectF2=new RectF(180,180,780,780);

        mPaint.setColor(Color.parseColor("#0000ff"));
        canvas.drawArc(rectF2,175,140,true,mPaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawWork9(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

        Path path=new Path();
        path.moveTo(400,400);

        path.addArc(400,300,600,500,180,180);
        path.addArc(600,300,800,500,180,180);
        path.lineTo(600,700);
        path.lineTo(400,400);

        canvas.drawPath(path,mPaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawWork8(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawRoundRect(300,300,800,800,50,100,mPaint);
    }

    private void drawWork7(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);

        canvas.drawLine(300,300,600,600,mPaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawWork6(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawOval(300, 300, 500, 400, mPaint);
    }

    private void drawWork5(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(300, 500, 30, mPaint);
        canvas.drawRect(600, 470, 660, 530, mPaint);
    }

    private void drawWork4(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        canvas.drawRect(300, 300, 900, 900, mPaint);
    }

    private void drawWork1(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

        float width = getMeasuredWidth() / 2;
        float height = getMeasuredHeight() / 2;
        RectF rect = new RectF(0, 0, (int) width, (int) height);
//        canvas.drawOval(rect,mPaint);

        canvas.drawArc(rect, 240, 120, true, mPaint);

        Path path = new Path();
        path.addArc(rect, 30, 120);
        path.close();
        canvas.drawPath(path, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawArc(rect, 180, 50, false, mPaint);
    }

    private void drawWork2(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#33ff0000"));
    }

    private void drawWork3(Canvas canvas) {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(300, 200, 150, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        canvas.drawCircle(700, 200, 150, mPaint);

        mPaint.setColor(Color.parseColor("#33ff0000"));
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300, 700, 150, mPaint);

        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(700, 700, 200, mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(700, 700, 150, mPaint);
    }

}
