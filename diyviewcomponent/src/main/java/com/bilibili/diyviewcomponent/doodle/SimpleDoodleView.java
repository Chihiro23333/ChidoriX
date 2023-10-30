package com.bilibili.diyviewcomponent.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimpleDoodleView extends View {

    private GestureDetector gestureDetector;

    private float lastX,lastY;

    private List<Path> pathList = new ArrayList<>();

    private Path curPath;

    private Paint paint = new Paint();

    public SimpleDoodleView(Context context) {
        super(context);
    }

    public SimpleDoodleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleDoodleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        // 设置画笔
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);

        gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDown(MotionEvent e) {
                lastX = e.getX();
                lastY = e.getY();
                curPath = new Path();
                curPath.moveTo(lastX, lastY);
                pathList.add(curPath);
                invalidate();
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                float x = e2.getX();
                float y = e2.getY();
                curPath.quadTo(lastX, lastY, (lastX + x)/2, (lastY + y)/2);
                lastX = x;
                lastY = y;
                invalidate();
                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean detectedUp = event.getAction() == MotionEvent.ACTION_UP;
        if ( !gestureDetector.onTouchEvent(event) && detectedUp ) {
            onUp(event);
        }
        return true;
    }

    private void onUp(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        curPath.quadTo(lastX, lastY, (lastX + x)/2, (lastY + y)/2);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Path path : pathList) { // 绘制涂鸦轨迹
            canvas.drawPath(path, paint);
        }
    }
}
