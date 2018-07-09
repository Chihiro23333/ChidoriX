package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PathView extends View {

    private Paint mPaint;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //普通PATH
//        Path path = new Path();
//        path.moveTo(100, 100);
//        path.lineTo(200, 200);
//        path.lineTo(100, 300);
//        path.close();
//        canvas.drawPath(path, mPaint);

        //矩形路径
        //逆时针
//        Path ccwPath = new Path();
//        RectF ccwRect = new RectF(100, 100, 400, 400);
//        ccwPath.addRect(ccwRect, Path.Direction.CCW);
//        canvas.drawPath(ccwPath, mPaint);
        //顺时针
//        Path cwPath = new Path();
//        RectF cwRect = new RectF(500, 500, 700, 700);
//        cwPath.addRect(cwRect, Path.Direction.CW);
//        canvas.drawPath(cwPath, mPaint);
//
//        String text = "打败鸣人的办法,堵了她的嘴,打败路飞的办法,把肉扔海里,打败纳兹的办法,把他音响砸了!";
//        canvas.drawTextOnPath(text, ccwPath, 0, 18, mPaint);
//        canvas.drawTextOnPath(text, cwPath, 0, 18, mPaint);

        //圆角矩形路径
//        RectF rectF = new RectF(200, 800, 400, 900);
//        Path roundCcwPath = new Path();
//        roundCcwPath.addRoundRect(rectF, 10, 15, Path.Direction.CCW);
//        canvas.drawPath(roundCcwPath, mPaint);
//
//        RectF rectF1 = new RectF(500, 800, 700, 900);
//        Path roundCwPath = new Path();
//        float[] radius = new float[]{10, 15, 20, 25, 30, 35, 80, 90};
//        roundCwPath.addRoundRect(rectF1, radius, Path.Direction.CCW);
//        canvas.drawPath(roundCwPath, mPaint);

        //圆形路径
//        Path circlePath = new Path();
//        circlePath.addCircle(300 ,1200 ,100 , Path.Direction.CCW);
//        canvas.drawPath(circlePath ,mPaint);

        //椭圆形路径
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Path roundOath = new Path();
//            roundOath.addOval(300 ,1400 ,500 ,1600 , Path.Direction.CCW);
//            canvas.drawPath(roundOath ,mPaint);
//        }

        //画弧形
//        Path arcPath = new Path();
//        RectF arcRect = new RectF(300 ,1700 ,500 ,1500);
//        arcPath.addArc(arcRect ,0 ,120);
//        canvas.drawPath(arcPath ,mPaint);

        //文字

        mPaint.setTextSize(80);
        mPaint.setStrokeWidth(5);
        mPaint.setTextSkewX((float) -0.25f);
        canvas.drawText("妖精的尾巴", 0, 100, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawText("妖精的尾巴", 0, 200, mPaint);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText("妖精的尾巴", 0, 300, mPaint);

        // Typeface	create可修改字体
    }
}
