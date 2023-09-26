package com.bilibili.diyviewcomponent.spotlight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class FocusLight extends View {

    private static final String TAG = "SpotLight";

    private static final int MIN_RADIUS = 400;

    private int moveRadius = MIN_RADIUS / 2;

    private Paint bgPaint;
    private Paint movePaint;
    private Paint mPaint;

    private int lastX, lastY, lastX1, lastY1;
    private int x, y;
    private int x1, y1;
    private int moveX = moveRadius, moveY = moveRadius;
    private int moveDX = 0, moveDY = 0;

    private Bitmap bgBmp;

    private int bgColor = Color.argb(180, 0, 0, 0);

    private boolean isPointerDown = false;
    private boolean hasMorePointerUp = false;

    private Canvas canvasbg;

    public FocusLight(Context context) {
        this(context, null);
    }

    public FocusLight(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FocusLight(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        initCacheBmp();
    }

    private void initCacheBmp() {
        post(new Runnable() {
            @Override
            public void run() {
                bgBmp = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                bgBmp.eraseColor(bgColor);
                canvasbg = new Canvas(bgBmp);
                postInvalidate();
            }
        });
    }

    private void initPaint() {

        bgPaint = new Paint();
        bgPaint.setColor(bgColor);

        movePaint = new Paint();
        movePaint.setAntiAlias(true);
        movePaint.setDither(true);
        movePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));

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

                if (isPointInCircle(x, y)) {
                    moveDX = x - moveX;
                    moveDY = y - moveY;
                }

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

                        if (x - lastX != 0 || y - lastY != 0) {
                            lastX = x;
                            lastY = y;

                            Log.i(TAG, "moveDX=" + moveDX + "moveDY=" + moveDY);
                            moveX = x - moveDX;
                            moveY = y - moveDY;
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

                    if (gap != 0) {
                        float scale = caculateScale();
                        correctRadius(scale);
                        //最大并且缩小操作或者最小并且放大操作
                        if (!isMaxScale() && !isMinScale()) {
                            postInvalidate();
                        }
                        Log.i(TAG, "scale=" + scale);
                    }

                    lastX = x;
                    lastY = y;
                    lastX1 = x1;
                    lastY1 = y1;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                isPointerDown = false;
                hasMorePointerUp = false;
                break;
        }

        return true;
    }

    private void correctRadius(float scale) {
        moveRadius = (int) (moveRadius * scale);
        //最大并且是放大操作,修正
        if (isMaxScale() && scale > 1) {
            if (moveRadius * 2 > getWidth()) {
                moveRadius = getWidth() / 2;
                return;
            }

            if (moveRadius * 2 > getHeight()) {
                moveRadius = getHeight() / 2;
                return;
            }
        }

        //最小并且是缩小操作,修正
        if (isMinScale() && scale < 1) {
            moveRadius = MIN_RADIUS / 2;
            return;
        }
    }

    private float caculateScale() {
        float scale = (float) (Math.sqrt((y1 - y) * (y1 - y) * 1.0d + (x1 - x) * (x1 - x) * 1.0d) /
                Math.sqrt((lastY1 - lastY) * (lastY1 - lastY) * 1.0d + (lastX1 - lastX) * (lastX1 - lastX) * 1.0d));
        return scale;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (canvasbg == null) {
            return;
        }

        correctXY();

        float centerX = moveX;
        float centerY = moveY;
        Log.i(TAG, "radius =" + moveRadius);
        RadialGradient r = new RadialGradient(centerX, centerY, moveRadius,
                new int[]{Color.TRANSPARENT, Color.TRANSPARENT},
                new float[]{0.75f, 1.0f},
                Shader.TileMode.CLAMP);
        movePaint.setShader(r);
        bgBmp.eraseColor(bgColor);
        canvasbg.drawCircle(centerX, centerY, moveRadius, movePaint);

        canvas.drawBitmap(bgBmp, 0, 0, mPaint);
    }

    private boolean isMaxScale() {
        boolean isMacxScale = moveRadius * 2 >= getWidth() || moveRadius * 2 >= getHeight();
        Log.i(TAG, "isMaxScale = " + isMacxScale);
        return isMacxScale;
    }

    private boolean isMinScale() {
        boolean isMinScale = moveRadius <= MIN_RADIUS / 2;
        Log.i(TAG, "isMinScale = " + isMinScale);
        return isMinScale;
    }

    private void correctXY() {
        int left = moveRadius;
        int top = moveRadius;
        int right = getWidth() - moveRadius;
        int bottom = getHeight() - moveRadius;

        moveX = moveX < left ? left : moveX;
        moveX = moveX > right ? right : moveX;

        moveY = moveY < top ? top : moveY;
        moveY = moveY > bottom ? bottom : moveY;
    }

    private boolean isPointInCircle(int downX, int downY) {

        float centerX = moveX;
        float centerY = moveY;

        //点击位置x坐标与圆心的x坐标的距离
        int distanceX = (int) Math.abs(centerX - downX);
        //点击位置y坐标与圆心的y坐标的距离
        int distanceY = (int) Math.abs(centerY - downY);

        Log.i(TAG, "centerX=" + centerX + "centerY=" + centerY + "downX=" + downX + "downY=" + downY);

        //点击位置与圆心的直线距离
        int distanceZ = (int) Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));

        Log.i(TAG, "distanceZ=" + distanceZ + "r=" + moveRadius / 2 + "isIn=" + (distanceZ > moveRadius / 2));

        //如果点击位置与圆心的距离大于圆的半径，证明点击位置没有在圆内
        if (distanceZ > moveRadius) {
            return false;
        }

        return true;
    }
}