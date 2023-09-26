package com.bilibili.diyviewcomponent.spotlight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class SpotLight extends View {

    private static final String TAG = "SpotLight";

    private static final int MIN_RADIUS = 400;
    private static final int TOUCH_SLOP = 4;

    private int moveRadius = MIN_RADIUS;

    private Paint bgPaint;
    private Paint movePaint;
    private Paint mPaint;

    private int lastX, lastY, lastX1, lastY1;
    private int x, y;
    private int x1, y1;
    private int moveX = moveRadius / 2, moveY = moveRadius / 2;
    private int moveDX, moveDY;

    private Bitmap bgBmp, moveBmp;

    private int bgColor = Color.argb(180, 0, 0, 0);

    private boolean isPointerDown = false;
    private boolean hasMorePointerUp = false;

    private float scale = 1.0f;

    public SpotLight(Context context) {
        this(context, null);
    }

    public SpotLight(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpotLight(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {

        bgPaint = new Paint();
        bgPaint.setColor(bgColor);

        movePaint = new Paint();
        movePaint.setAntiAlias(true);
        movePaint.setDither(true);

        mPaint = new Paint();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() > 2) {
            return false;
        }
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:

                x = (int) event.getX();
                y = (int) event.getY();

                lastX = (int) event.getX();
                lastY = (int) event.getY();

                moveDX = x - moveX;
                moveDX = y - moveY;

                return true;
            case MotionEvent.ACTION_POINTER_DOWN:
                isPointerDown = true;

                x1 = (int) event.getX(1);
                y1 = (int) event.getY(1);

                lastX1 = (int) event.getX(1);
                lastY1 = (int) event.getY(1);
                break;
            case MotionEvent.ACTION_POINTER_UP:
                // 判断是否有手指抬起
                isPointerDown = false;
                hasMorePointerUp = true;
                break;
            case MotionEvent.ACTION_MOVE:
                //单指
                if (!isPointerDown) {
                    if (!hasMorePointerUp) {

                        int x = (int) event.getX();
                        int y = (int) event.getY();

                        int gap = (int) Math.sqrt(Math.pow(x - lastX, 2) + Math.pow(y - lastY, 2));

                        if (gap > TOUCH_SLOP) {
                            lastX = moveX = x;
                            lastY = moveY = y;
                            postInvalidate();
                        } else {
                            if (!isPointInCircle(x, y)) {
                                moveX = x;
                                moveY = y;
                                postInvalidate();
                            }
                        }
                    }
                } else {
                    //双指
                    x = (int) event.getX(0);
                    y = (int) event.getY(0);

                    x1 = (int) event.getX(1);
                    y1 = (int) event.getY(1);

                    int gap = (int) Math.sqrt(Math.pow(x - lastX, 2) + Math.pow(y - lastY, 2)) +
                            (int) Math.sqrt(Math.pow(x1 - lastX1, 2) + Math.pow(y1 - lastY1, 2));

                    if (gap > TOUCH_SLOP) {
                        scale = caculateScale();
                        correctScale();
                        postInvalidate();
                    }
                }
                Log.i(TAG, "scale=" + scale);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isPointerDown = false;
                hasMorePointerUp = false;

                moveRadius = (int) (moveRadius * scale);
                scale = 1.0f;
                break;
        }

        return true;
    }

    private float caculateScale() {
        return (float) (Math.sqrt((y1 - y) * (y1 - y) * 1.0d + (x1 - x) * (x1 - x) * 1.0d) /
                Math.sqrt((lastY1 - lastY) * (lastY1 - lastY) * 1.0d + (lastX1 - lastX) * (lastX1 - lastX) * 1.0d));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (bgBmp == null) {
            bgBmp = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvasbg = new Canvas(bgBmp);
            Rect rect = new Rect(0, 0, getWidth(), getHeight());
            canvasbg.drawRect(rect, bgPaint);
        }

        if (moveBmp == null || isPointerDown) {

            int radius = (int) (moveRadius * scale / 2);

            Log.i(TAG, "radius =" + radius);

            moveBmp = Bitmap.createBitmap(radius * 2, radius * 2, Bitmap.Config.ARGB_8888);
            Canvas moveCanvas = new Canvas(moveBmp);
//            RadialGradient r = new RadialGradient(radius, radius, radius,
//                    new int[]{Color.argb(255, 255, 255, 255), Color.argb(0, 255, 255, 255)},
//                    new float[]{0.8f, 1.0f},
//                    Shader.TileMode.CLAMP);
//            movePaint.setShader(r);
            moveCanvas.drawCircle(radius, radius, radius, movePaint);
        }


        int layerID = canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(bgBmp, 0, 0, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

        correctXY();

        float startX = getCenterX() - moveRadius * scale / 2;
        float startY = getCenterY() - moveRadius * scale / 2;

        canvas.drawBitmap(moveBmp, startX, startY, mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerID);
    }

    private int getCenterY() {
        return moveY + moveDY;
    }

    private int getCenterX() {
        return moveX + moveDX;
    }

    private void correctScale() {
        //计算最大的scale
        float max = Math.min(getWidth() * 1.0f / moveRadius, getHeight() * 1.0f / moveRadius);
        float min = MIN_RADIUS * 1.0f / moveRadius;

        Log.i(TAG, "scale=" + scale + "min=" + min);

        scale = scale > max ? max : scale;
        scale = scale < min ? min : scale;
    }

    private void correctXY() {
        int left = (int) (moveRadius * scale / 2);
        int top = (int) (moveRadius * scale / 2);
        int right = getWidth() - (int) (moveRadius * scale / 2);
        int bottom = getHeight() - (int) (moveRadius * scale / 2);

        moveDX = getCenterX() < left ? left : moveDX + (getCenterX() - left);
        moveDX = getCenterX() > right ? right : moveDX - (getCenterX() - right);

        moveDY = getCenterX() < top ? top : moveDY + (getCenterY() - top);
        moveDY = getCenterY() > bottom ? bottom : moveDY + (getCenterY() - bottom);
    }

    private boolean isPointInCircle(int downX, int downY) {

        float centerX = getCenterX();
        float centerY = getCenterY();

        //点击位置x坐标与圆心的x坐标的距离
        int distanceX = (int) Math.abs(centerX - downX);
        //点击位置y坐标与圆心的y坐标的距离
        int distanceY = (int) Math.abs(centerY - downY);

        Log.i(TAG, "centerX=" + centerX + "centerY=" + centerY + "downX=" + downX + "downY=" + downY);

        //点击位置与圆心的直线距离
        int distanceZ = (int) Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));

        Log.i(TAG, "distanceZ=" + distanceZ + "r=" + moveRadius * scale / 2 + "isIn=" + (distanceZ > moveRadius * scale / 2));

        //如果点击位置与圆心的距离大于圆的半径，证明点击位置没有在圆内
        if (distanceZ > moveRadius * scale / 2) {
            return false;
        }

        return true;
    }
}