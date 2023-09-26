package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CanvasOperationView extends View {

    private Paint mPaint;

    public CanvasOperationView(Context context) {
        this(context, null);
    }

    public CanvasOperationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasOperationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(30);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);


//        Path path = new Path();
//        path.addRect(new RectF(0, 0, 300, 300), Path.Direction.CCW);
//        canvas.drawPath(path, mPaint);
//
//        canvas.translate(300, 300);
//        canvas.drawPath(path, mPaint);
//
//        canvas.translate(300, 300);
//        canvas.rotate(30);
//        canvas.drawPath(path, mPaint);
//
//        canvas.scale(0.5f, 1);
//        canvas.drawPath(path, mPaint);
//
//        canvas.skew(1.732f, 0);
//        canvas.drawPath(path, mPaint);

        //裁剪画布
//        boolean	clipPath(Path path)
//        boolean	clipPath(Path path, Region.Op op)
//        boolean	clipRect(Rect rect, Region.Op op)
//        boolean	clipRect(RectF rect, Region.Op op)
//        boolean	clipRect(int left, int top, int right, int bottom)
//        boolean	clipRect(float left, float top, float right, float bottom)
//        boolean	clipRect(RectF rect)
//        boolean	clipRect(float left, float top, float right, float bottom, Region.Op op)
//        boolean	clipRect(Rect rect)
//        boolean	clipRegion(Region region)
//        boolean	clipRegion(Region region, Region.Op op)


        //画布的保存与恢复（save()、restore()）
        canvas.drawColor(Color.RED);
        canvas.save();

        canvas.clipRect(new Rect(300, 300, 600, 600));
        canvas.drawColor(Color.BLUE);
        canvas.save();

        canvas.clipRect(new Rect(350, 350, 550, 550));
        canvas.drawColor(Color.CYAN);
        canvas.save();

        canvas.clipRect(new Rect(400, 400, 500, 500));
        canvas.drawColor(Color.BLACK);
        canvas.save();

        canvas.restore();

        canvas.restore();

        canvas.restore();


        canvas.translate(100 ,100);
        canvas.drawColor(Color.YELLOW);
    }
}
