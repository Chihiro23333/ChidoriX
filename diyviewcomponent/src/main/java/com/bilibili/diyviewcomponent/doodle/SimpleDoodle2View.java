package com.bilibili.diyviewcomponent.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimpleDoodle2View extends View {

    private GestureDetector gestureDetector;

    private float lastX,lastY;

    private List<PathItem> pathList = new ArrayList<>();

    private Path curPath;

    private PathItem selectPath;

    private Paint paint = new Paint();


    public SimpleDoodle2View(Context context) {
        super(context);
    }

    public SimpleDoodle2View(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleDoodle2View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                Matrix matrix = new Matrix();
                PathItem pathItem = new PathItem();
                pathItem.matrix = matrix;
                pathItem.path = curPath;
                pathList.add(pathItem);
                invalidate();
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                float x = e2.getX();
                float y = e2.getY();

                if(selectPath != null){
                    Matrix matrix = selectPath.matrix;
                    matrix.postTranslate(-distanceX, -distanceY);
                    invalidate();
                }else {
                    curPath.quadTo(lastX, lastY, (lastX + x)/2, (lastY + y)/2);
                    lastX = x;
                    lastY = y;
                    invalidate();
                }
                return true;
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                float x = e.getX();
                float y = e.getY();
                for (int i = 0; i < pathList.size(); i++) {
                    PathItem pathItem = pathList.get(i);
                    Path path = pathItem.path;
                    RectF rectF = new RectF();
                    path.computeBounds(rectF, true);
                    if(rectF.contains(x,y)){
                        selectPath =  pathItem;
                        invalidate();
                        break;
                    }
                }
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
        if(selectPath != null){
            paint.setColor(Color.YELLOW);
            canvas.save();
            canvas.setMatrix(selectPath.matrix);
            canvas.drawPath(selectPath.path, paint);
            canvas.restore();
        }else {
            paint.setColor(Color.RED);
            for (PathItem path : pathList) { // 绘制涂鸦轨迹
                canvas.save();
                canvas.setMatrix(path.matrix);
                canvas.drawPath(path.path, paint);
                canvas.restore();
            }
        }
    }

    private class PathItem{
        Path path;
        Matrix matrix;
    }
}
