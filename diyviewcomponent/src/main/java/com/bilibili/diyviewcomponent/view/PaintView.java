package com.bilibili.diyviewcomponent.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import javax.xml.validation.Validator;

/**
 * Created by Chihiro on 2018/7/23.
 *
 * Paint之函数大汇总
 */

public class PaintView extends View{


    private Paint mPaint;

    private int dx = 0;
    private ValueAnimator valueAnimator;

    public PaintView(Context context) {
        this(context ,null);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();

        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawLine(100 ,300 ,400 ,300 ,mPaint);
//
//        mPaint.setStrokeCap(Paint.Cap.BUTT);
//        canvas.drawLine(100 ,500 ,400 ,500 ,mPaint);
//
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        canvas.drawLine(100 ,600 ,400 ,600 ,mPaint);
//
//        mPaint.setStrokeCap(Paint.Cap.SQUARE);
//        canvas.drawLine(100 ,700 ,400 ,700 ,mPaint);
//
//        Path path = new Path();
//        path.moveTo(100 ,100);
//        path.lineTo(200 ,200);
//        path.lineTo(100 ,300);
//        canvas.drawPath(path ,mPaint);
//
//        canvas.translate(300 ,300);
//        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        canvas.drawPath(path ,mPaint);

//
//        Path path1 = new Path();
//        path1.moveTo(100 ,500);
//        path1.lineTo(400 ,200);
//        path1.lineTo(600 ,600);
//
//
//        mPaint.setStrokeWidth(4);
//
//        canvas.drawPath(path1 ,mPaint);
//
//        mPaint.setPathEffect(new CornerPathEffect(100));
//        canvas.drawPath(path1 ,mPaint);
//
//        mPaint.setPathEffect(new CornerPathEffect(200));
//        canvas.drawPath(path1 ,mPaint);

        Path path2 = new Path();
        path2.moveTo(100 ,500);
        path2.lineTo(400 ,200);
        path2.lineTo(600 ,600);

        mPaint.setStrokeWidth(4);

        canvas.drawPath(path2 ,mPaint);
        canvas.translate(0 ,100);

        mPaint.setPathEffect(new DashPathEffect(new float[]{10 ,10 ,100 ,100} ,dx));
        canvas.drawPath(path2 ,mPaint);


        mPaint.setPathEffect(new DashPathEffect(new float[]{10 ,30 ,50 ,70} ,dx));
        canvas.drawPath(path2 ,mPaint);

        if(valueAnimator == null){
            startAnimation();
        }

    }

    private void startAnimation(){
        valueAnimator = ValueAnimator.ofInt(220);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dx = (int) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }
}
