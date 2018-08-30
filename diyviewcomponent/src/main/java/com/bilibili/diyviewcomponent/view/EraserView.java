package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.bilibili.diyviewcomponent.R;

/**
 * Created by Chihiro on 2018/7/30.
 */

public class EraserView extends View {

    private Paint mPaint;
    private Bitmap dstBitmap;
    private Bitmap srcBitmap;
    private Path path;

    private float downX;
    private float downY;

    public EraserView(Context context) {
        this(context, null);
    }

    public EraserView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EraserView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);

        srcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test,null);

        dstBitmap = Bitmap.createBitmap(srcBitmap.getWidth(), srcBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int layerId = canvas.saveLayer(new RectF(0, 0, getWidth(), getHeight()), null, Canvas.ALL_SAVE_FLAG);

        Canvas canvas1 = new Canvas(dstBitmap);
        canvas1.drawPath(path, mPaint);

            canvas.drawBitmap(dstBitmap, 0, 0, mPaint);

        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        canvas.drawBitmap(srcBitmap, 0, 0, mPaint);

        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                path.moveTo(downX, downY);
                return true;
            case MotionEvent.ACTION_MOVE:
                float moveX = event.getX();
                float moveY = event.getY();
                float endX = (downX + moveX) / 2;
                float endY = (downY + moveY) / 2;

                path.quadTo(downX, downY, endX, endY);

                downX = moveX;
                downY = moveY;
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }
}
