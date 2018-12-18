package com.bilibili.diyviewcomponent.spotlight.spotlight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;


public class RoundSpotLightView extends BaseSpotLightView implements ILightLocation {

    private static final String TAG = "SpotLight";

    private static final int MIN_RADIUS = 300;

    private static final int LONG_CLICK_DURATION = 500;

    private int moveRadius = MIN_RADIUS / 2;

    private Paint bgPaint;
    private Paint movePaint;
    private Paint mPaint;

    private int downX, downY, lastX1, lastY1;
    private int x, y;
    private int x1, y1;
    private int moveX = moveRadius, moveY = moveRadius;
    private int moveDX = 0, moveDY = 0;

    private Bitmap bgBmp;

    private int bgColor = Color.argb(180, 0, 0, 0);

    private boolean isPointerDown = false;
    private boolean hasMorePointerUp = false;
    private boolean isMoving = false;
    private boolean isDownInCircle = false;

    private Canvas canvasbg;

    private OnLongClickListener onLongClickListener;

    private int touchSlop;

    private Runnable longClickRunnable = new Runnable() {
        @Override
        public void run() {
            if (onLongClickListener != null) {
                onLongClickListener.onLongClick(RoundSpotLightView.this);
            }
        }
    };

    @Override
    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public RoundSpotLightView(Context context) {
        this(context, null);
    }

    public RoundSpotLightView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundSpotLightView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {

        bgPaint = new Paint();
        bgPaint.setColor(bgColor);

        movePaint = new Paint();
        movePaint.setAntiAlias(true);
        movePaint.setDither(true);
        movePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));

        mPaint = new Paint();

        touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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

                downX = (int) event.getX();
                downY = (int) event.getY();

                if (isPointInCircle(x, y)) {
                    isDownInCircle = true;
                    moveDX = x - moveX;
                    moveDY = y - moveY;
                } else {
                    isDownInCircle = false;
                    postDelayed(longClickRunnable, 500);
                }

                return true;
            case MotionEvent.ACTION_POINTER_DOWN:
                isPointerDown = true;

                x1 = (int) event.getX(1);
                y1 = (int) event.getY(1);

                lastX1 = (int) event.getX(1);
                lastY1 = (int) event.getY(1);

                removeCallbacks(longClickRunnable);
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

                        x = (int) event.getX();
                        y = (int) event.getY();

                        int gap = (int) Math.sqrt(Math.pow(x - downX, 2) + Math.pow(y - downY, 2));
                        if (gap > touchSlop || isMoving) {
                            isMoving = true;
                            removeCallbacks(longClickRunnable);
                            downX = x;
                            downY = y;

                            Log.i(TAG, "moveDX=" + moveDX + "moveDY=" + moveDY);
                            moveX = x - moveDX;
                            moveY = y - moveDY;
                            postInvalidate();
                        }
                    }
                } else {
                    //双指
                    x = (int) event.getX(0);
                    y = (int) event.getY(0);

                    x1 = (int) event.getX(1);
                    y1 = (int) event.getY(1);

                    int gap = (int) Math.sqrt(Math.pow(x - downX, 2) + Math.pow(y - downY, 2)) +
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

                    downX = x;
                    downY = y;
                    lastX1 = x1;
                    lastY1 = y1;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:

                if (!isDownInCircle && !hasMorePointerUp) {
                    moveX = x;
                    moveY = y;
                    postInvalidate();
                }

                resetAll();

                break;
        }

        return true;
    }

    private void resetAll() {
        isPointerDown = false;
        hasMorePointerUp = false;
        isMoving = false;
        isDownInCircle = false;
        moveDX = moveDY = 0;
        removeCallbacks(longClickRunnable);
    }

    private void correctRadius(float scale) {
        moveRadius = (int) (moveRadius * scale);

        //最大并且是放大操作,修正
        if (isMaxScale() && scale > 1) {
            int realWidth = getRealWidth();
            if (moveRadius * 2 > realWidth) {
                moveRadius = realWidth / 2;
                return;
            }

            int realHeight = getRealHeight();
            if (moveRadius * 2 > realHeight) {
                moveRadius = realHeight / 2;
                return;
            }
        }

        //最小并且是缩小操作,修正
        if (isMinScale() && scale < 1) {
            moveRadius = MIN_RADIUS / 2;
            return;
        }
    }

    private int getRealHeight() {
        return getHeight() - moveMargin[1] - moveMargin[3];
    }

    private int getRealWidth() {
        return getWidth() - moveMargin[0] - moveMargin[2];
    }

    private float caculateScale() {
        float scale = (float) (Math.sqrt((y1 - y) * (y1 - y) * 1.0d + (x1 - x) * (x1 - x) * 1.0d) /
                Math.sqrt((lastY1 - downY) * (lastY1 - downY) * 1.0d + (lastX1 - downX) * (lastX1 - downX) * 1.0d));
        return scale;
    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility != VISIBLE && changedView instanceof RoundSpotLightView) {
            resetAll();
            resetMoveMargin();
        }
    }

    private void resetMoveMargin() {
        moveMargin[0] = moveMargin[1] = moveMargin[2] = moveMargin[3] = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (canvasbg == null) {
            bgBmp = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            bgBmp.eraseColor(bgColor);
            canvasbg = new Canvas(bgBmp);
        }

        correctXY();

        float centerX = moveX;
        float centerY = moveY;
        Log.i(TAG, "radius =" + moveRadius);
        RadialGradient r = new RadialGradient(centerX, centerY, moveRadius,
                new int[]{Color.TRANSPARENT, Color.TRANSPARENT},
                new float[]{1.0f, 1.0f},
                Shader.TileMode.CLAMP);
        movePaint.setShader(r);
        bgBmp.eraseColor(bgColor);
        canvasbg.drawCircle(centerX, centerY, moveRadius, movePaint);

        canvas.drawBitmap(bgBmp, 0, 0, mPaint);

        requestLayout();
    }

    private boolean isMaxScale() {
        boolean isMacxScale = moveRadius * 2 >= getRealWidth() || moveRadius * 2 >= getRealHeight();
        Log.i(TAG, "isMaxScale = " + isMacxScale);
        return isMacxScale;
    }

    private boolean isMinScale() {
        boolean isMinScale = moveRadius <= MIN_RADIUS / 2;
        Log.i(TAG, "isMinScale = " + isMinScale);
        return isMinScale;
    }

    private void correctXY() {

        int left = moveMargin[0] + moveRadius;
        int top = moveMargin[1] + moveRadius;
        int right = getWidth() - (moveMargin[2] + moveRadius);
        int bottom = getHeight() - (moveMargin[3] + moveRadius);

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


    @Override
    public int getLightLeft() {
        return moveX - moveRadius / 2;
    }

    @Override
    public int getLightBottom() {
        return moveY + moveRadius / 2;
    }

    @Override
    public ILightLocation getLightLocation() {
        return this;
    }
}