package com.bilibili.diyviewcomponent.watermark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.bilibili.diyviewcomponent.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author 朱峰 2019/5/29
 */
public class ImageWatermark extends AppCompatImageView implements EditableWatermark, GestureDetector.OnGestureListener {

    private static final String TAG = "ImageWatermark";

    private Matrix matrix;
    private Matrix cacheMatrix;  //缓存的matrix ，同时记录上一次滑动的位置

    private GestureDetector gestureDetector;

    private static final int NONE_DIRECTION = -1;
    private static final int LEFT_TOP = 0;
    private static final int LEFT_BOTTOM = 1;
    private static final int RIGHT_TOP = 2;
    private static final int RIGHT_BOTTOM = 3;

    private static final int TOUCH_RADIUS = 100;

    Map<Integer, RectF> scaleMap;

    private int touchDirection;

    private Paint touchPaint;

    public ImageWatermark(Context context) {
        super(context);
        setScaleType(ScaleType.MATRIX);

        gestureDetector = new GestureDetector(context, this);

        matrix = new Matrix();
        cacheMatrix = new Matrix();
        scaleMap = new HashMap<>();

        initPaint();
    }

    private void initPaint() {
        touchPaint = new Paint();
        touchPaint.setColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public void setWatermarkAlpha(float alpha) {
        setAlpha(alpha);
    }

    @Override
    public void setWatermarkTextSize(int textSize) {

    }

    @Override
    public void setWatermarkTextColor(int color) {
    }

    @Override
    public void setWatermarkImageSource(String path) {
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        setImageBitmap(bitmap);
    }

    @Override
    public void setWatermarkImageBitmap(Bitmap bitmap) {
        setImageBitmap(bitmap);
    }

    @Override
    public void setWatermarkText(String text) {

    }

    @Override
    public int getType() {
        return TYPE_IMG;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        cacheMatrix.set(matrix);
        updateScaleRect();
        touchDirection = getTouchDirection(e.getX(), e.getY());
//        Log.i(TAG, "downX="+e.getX()+":downY="+e.getY()+"touchD="+touchDirection);
        return isPointInRect(e.getX(), e.getY(),getMatrixRectF());
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        RectF matrixRectF = getMatrixRectF();
        float scaleRate;
        switch (touchDirection) {
            case LEFT_TOP:
                scaleRate = caculatePointToVertex(e2.getX(), e2.getY(), matrixRectF.right, matrixRectF.bottom) /
                        caculatePointToVertex(e2.getX() + distanceX, e2.getY() + distanceY, matrixRectF.right, matrixRectF.bottom);
                scaleRate = correctScaleRate(scaleRate);
                Log.i(TAG, "scaleRate=" + scaleRate);
                matrix.postScale(scaleRate, scaleRate, matrixRectF.right, matrixRectF.bottom);
                break;

            case LEFT_BOTTOM:
                scaleRate = caculatePointToVertex(e2.getX(), e2.getY(), matrixRectF.right, matrixRectF.top) /
                        caculatePointToVertex(e2.getX() + distanceX, e2.getY() + distanceY, matrixRectF.right, matrixRectF.top);
                scaleRate = correctScaleRate(scaleRate);
                Log.i(TAG, "scaleRate=" + scaleRate);
                matrix.postScale(scaleRate, scaleRate, matrixRectF.right, matrixRectF.top);
                break;

            case RIGHT_TOP:
                scaleRate = caculatePointToVertex(e2.getX(), e2.getY(), matrixRectF.left, matrixRectF.bottom) /
                        caculatePointToVertex(e2.getX() + distanceX, e2.getY() + distanceY, matrixRectF.left, matrixRectF.bottom);
                scaleRate = correctScaleRate(scaleRate);
                Log.i(TAG, "scaleRate=" + scaleRate);
                matrix.postScale(scaleRate, scaleRate, matrixRectF.left, matrixRectF.bottom);
                break;

            case RIGHT_BOTTOM:
                scaleRate = caculatePointToVertex(e2.getX(), e2.getY(), matrixRectF.left, matrixRectF.top) /
                        caculatePointToVertex(e2.getX() + distanceX, e2.getY() + distanceY, matrixRectF.left, matrixRectF.top);
                scaleRate = correctScaleRate(scaleRate);
                Log.i(TAG, "scaleRate=" + scaleRate);
                matrix.postScale(scaleRate, scaleRate, matrixRectF.left, matrixRectF.top);
                break;

            default:
                Log.i(TAG, "distanceX=" + distanceX + "distanceY=" + distanceY);
                Log.i(TAG, "left=" + matrixRectF.left + "right=" + matrixRectF.right);

                distanceX = matrixRectF.left - distanceX < 0 ? matrixRectF.left : distanceX;
                distanceX = matrixRectF.right - distanceX > getWidth() ? -getWidth() + matrixRectF.right : distanceX;

                distanceY = matrixRectF.top - distanceY < 0 ? matrixRectF.top : distanceY;
                distanceY = matrixRectF.bottom - distanceY > getHeight() ? -getHeight() + matrixRectF.bottom : distanceY;

                matrix.postTranslate(-distanceX, -distanceY);
        }
        setImageMatrix(matrix);

        //可以省略测的操作
        updateScaleRect();
        postInvalidate();
        return true;
    }

    private float correctScaleRate(float scaleRate) {
        RectF matrixRectF = getMatrixRectF();
        float w = matrixRectF.right - matrixRectF.left;
        float h = matrixRectF.bottom - matrixRectF.top;

        switch (touchDirection) {
            case LEFT_TOP:
                scaleRate = matrixRectF.right - w * scaleRate < 0 ? matrixRectF.right / w : scaleRate;
                Log.i(TAG, "getHeight()=" + getHeight() + " matrixRectF.bottom" + matrixRectF.bottom + "h" + h);
                scaleRate = (matrixRectF.bottom - h * scaleRate < 0) ? matrixRectF.bottom / h : scaleRate;
                break;

            case LEFT_BOTTOM:
                scaleRate = matrixRectF.right - w * scaleRate < 0 ? matrixRectF.right / w : scaleRate;
                scaleRate = matrixRectF.top + h * scaleRate > getHeight() ? (getHeight() - matrixRectF.top) / h : scaleRate;
                break;

            case RIGHT_TOP:
                scaleRate = matrixRectF.left + w * scaleRate > getWidth() ? (getWidth() - matrixRectF.left) / w : scaleRate;
                scaleRate = matrixRectF.bottom - h * scaleRate < 0 ? matrixRectF.bottom / h : scaleRate;
                break;

            case RIGHT_BOTTOM:
                scaleRate = matrixRectF.left + w * scaleRate > getWidth() ? (getWidth() - matrixRectF.left) / w : scaleRate;
                scaleRate = matrixRectF.top + h * scaleRate > getHeight() ? (getHeight() - matrixRectF.top) / h : scaleRate;
                break;

            default:
        }
        return scaleRate;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }


    private float caculatePointToVertex(float touchX, float touchY, float vertexX, float vertexY) {
        return (float) Math.sqrt(Math.pow(touchX - vertexX, 2) + Math.pow(touchY - vertexY, 2));
    }

    private int getTouchDirection(float x, float y) {
        Set<Map.Entry<Integer, RectF>> entries = scaleMap.entrySet();
        for (Map.Entry<Integer, RectF> entry : entries) {
            RectF value = entry.getValue();
            if (isPointInRect(x, y, value)) {
                return entry.getKey();
            }
        }
        return NONE_DIRECTION;
    }

    private boolean isPointInRect(float x, float y, RectF value) {
        Log.i(TAG, "x=" + x + "y=" + y + "left=" + value.left + "right=" + value.right + "top=" + value.top + "bottom=" + value.bottom);
        return x > value.left && x < value.right && y > value.top && y < value.bottom;
    }

    private void updateScaleRect() {
        RectF matrixRectF = getMatrixRectF();
        float left = matrixRectF.left;
        float right = matrixRectF.right;
        float top = matrixRectF.top;
        float bottom = matrixRectF.bottom;

//        Log.i(TAG,  "updateScaleRect left="+left+"right="+right);

        scaleMap.put(LEFT_TOP, new RectF(left, top, left + TOUCH_RADIUS, top + TOUCH_RADIUS));
        scaleMap.put(LEFT_BOTTOM, new RectF(left, bottom - TOUCH_RADIUS, left + TOUCH_RADIUS, bottom));
        scaleMap.put(RIGHT_TOP, new RectF(right - TOUCH_RADIUS, top, right, top + TOUCH_RADIUS));
        scaleMap.put(RIGHT_BOTTOM, new RectF(right - TOUCH_RADIUS, bottom - TOUCH_RADIUS, right, bottom));
    }

    private RectF getMatrixRectF() {
        Matrix m = matrix;
        RectF rect = new RectF();
        Drawable d = getDrawable();
        if (null != d) {
            rect.set(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
            m.mapRect(rect);
        }
        //第二种方法  （两种方法均可）
//        Matrix m = new Matrix();
//        m.set(matrix);
//        RectF rect = new RectF(0, 0, gintama.getWidth(), gintama.getHeight());
//        m.mapRect(rect);
        return rect;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTouchRectF(canvas);
    }

    private void drawTouchRectF(Canvas canvas) {
        Set<Map.Entry<Integer, RectF>> entries = scaleMap.entrySet();
        for (Map.Entry<Integer, RectF> entry : entries) {
            RectF value = entry.getValue();
            canvas.drawRect(value, touchPaint);
        }
    }
}
