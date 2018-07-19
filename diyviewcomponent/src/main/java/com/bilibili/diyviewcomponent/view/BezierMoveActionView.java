package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class BezierMoveActionView extends View {

    private Paint mPaint;

    private Path mPath;

    private float mPreX;
    private float mPreY;

    public BezierMoveActionView(Context context) {
        this(context, null);
    }

    public BezierMoveActionView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierMoveActionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);

        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        Path path = new Path();
//        path.moveTo(300, 300);
//        path.quadTo(400, 100, 500, 300);
//        path.quadTo(600, 500, 700, 300);
//
//        canvas.drawPath(path, mPaint);

        canvas.drawPath(mPath, mPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(), event.getY());
                mPreX = event.getX();
                mPreY = event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                float endX = (event.getX() + mPreX) / 2;
                float endY = (event.getY() + mPreY) / 2;
                mPath.quadTo(mPreX, mPreY, endX, endY);
                mPreX = event.getX();
                mPreY = event.getY();
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }
}
