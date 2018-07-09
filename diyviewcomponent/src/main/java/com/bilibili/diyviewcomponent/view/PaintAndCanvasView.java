package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PaintAndCanvasView extends View {

    private Paint mPaint;

    public PaintAndCanvasView(Context context) {
        this(context, null);
    }

    public PaintAndCanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintAndCanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(30);
        mPaint.setStyle(Paint.Style.FILL);

        mPaint.setShadowLayer(20, 10, 10, Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画布颜色
//        canvas.drawColor(Color.BLUE);
        //画圆
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 200, mPaint);
        //画线
//        canvas.drawLine(100, 100, 300, 300, mPaint);
        //画点
//        canvas.drawPoint(500, 500, mPaint);
        //画方形
//        canvas.drawRect(100, 100, 300, 300, mPaint);
        //画带圆角的方形
        RectF rectF = new RectF(200, 200, 600, 600);
//        canvas.drawRoundRect(rectF, 10, 20, mPaint);
        //画椭圆
//        canvas.drawOval(rectF ,mPaint);
        //画弧度
        canvas.drawArc(rectF ,0 ,100 ,false ,mPaint);
    }
}
