package com.bilibili.diyviewcomponent.watermark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.bilibili.diyviewcomponent.view.BitmapView;

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

    private static final int WATERMARK_MIN_WIDTH = 30;
    private static final int TOUCH_AREA_OUTER = 50;

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
        touchPaint.setColor(Color.RED);
        touchPaint.setStrokeWidth(3);
        touchPaint.setStyle(Paint.Style.STROKE);
        touchPaint.setPathEffect(new DashPathEffect(new float[]{20, 20}, 0));
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
        //真实宽度小于最低宽度
        if (getRealWidth() < WATERMARK_MIN_WIDTH * 2 || getRealHeight() < WATERMARK_MIN_WIDTH * 2) {
            RectF matrixRectF = getMatrixRectF();
            float scale = Math.max(WATERMARK_MIN_WIDTH * 2 / getRealHeight(), WATERMARK_MIN_WIDTH * 2 / getRealWidth());
            matrix.postScale(scale, scale, matrixRectF.right, matrixRectF.top);
        }
        //真实宽度大于最低宽度，缩小并移动到最右边
        if (getRealWidth() > WATERMARK_MIN_WIDTH * 4 || getRealHeight() > WATERMARK_MIN_WIDTH * 2) {
            RectF matrixRectF = getMatrixRectF();
            float scale = Math.max(WATERMARK_MIN_WIDTH * 4 / getRealHeight(), WATERMARK_MIN_WIDTH * 4 / getRealWidth());
            matrix.postScale(scale, scale, matrixRectF.right, matrixRectF.top);
        }
        move(-10000, 10000);
        setImageMatrix(matrix);
    }

    @Override
    public void setWatermarkText(String text) {

    }

    @Override
    public float getLeftRelativeToWidth() {
        return getMatrixRectF().left / getWidth();
    }

    @Override
    public float getRightRelativeToWidth() {
        return getMatrixRectF().right / getWidth();
    }

    @Override
    public float getTopRelativeToHeight() {
        return getMatrixRectF().top / getHeight();
    }

    @Override
    public float getBottomRelativeToHeight() {
        return getMatrixRectF().bottom / getHeight();
    }

    @Override
    public Bitmap getBitmap() {
        return getBitmap(getDrawable());
    }

    @Override
    public float getWatermarkAlpha() {
        return getAlpha();
    }

    private Bitmap getBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(
                (int) getRealWidth(),
                (int) getRealHeight(),
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                        : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, (int) getRealWidth(), (int) getRealHeight());
        drawable.draw(canvas);
        return bitmap;
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
        Log.i(TAG, "downX=" + e.getX() + ":downY=" + e.getY() + "touchD=" + touchDirection);
        return isPointInRect(e.getX(), e.getY(), getMatrixRectFWithTouchArea());
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
        Log.i(TAG, "distanceX=" + distanceX + ":distanceY" + distanceY);
        float x = e2.getX();
        float y = e2.getY();
        float scaleRate;
        switch (touchDirection) {
            case LEFT_TOP:
                if (x <= matrixRectF.right && y <= matrixRectF.bottom) {
                    scaleRate = caculatePointToVertex(x, y, matrixRectF.right, matrixRectF.bottom) /
                            caculatePointToVertex(x + distanceX, y + distanceY, matrixRectF.right, matrixRectF.bottom);
                    scaleRate = correctScaleRate(scaleRate);
                    Log.i(TAG, "scaleRate=" + scaleRate);
                    matrix.postScale(scaleRate, scaleRate, matrixRectF.right, matrixRectF.bottom);
                }
                break;

            case LEFT_BOTTOM:
                Log.i(TAG, "x=" + x + ":y=" + y + "matrixRectF.right=" + matrixRectF.right + "matrixRectF.top=" + matrixRectF.top);
                if (x <= matrixRectF.right && y >= matrixRectF.top) {
                    scaleRate = caculatePointToVertex(x, y, matrixRectF.right, matrixRectF.top) /
                            caculatePointToVertex(x + distanceX, y + distanceY, matrixRectF.right, matrixRectF.top);
                    scaleRate = correctScaleRate(scaleRate);
                    Log.i(TAG, "scaleRate=" + scaleRate);
                    matrix.postScale(scaleRate, scaleRate, matrixRectF.right, matrixRectF.top);
                }
                break;

            case RIGHT_TOP:
                if (x >= matrixRectF.left && y <= matrixRectF.bottom) {
                    scaleRate = caculatePointToVertex(x, y, matrixRectF.left, matrixRectF.bottom) /
                            caculatePointToVertex(x + distanceX, y + distanceY, matrixRectF.left, matrixRectF.bottom);
                    scaleRate = correctScaleRate(scaleRate);
                    Log.i(TAG, "scaleRate=" + scaleRate);
                    matrix.postScale(scaleRate, scaleRate, matrixRectF.left, matrixRectF.bottom);
                }
                break;

            case RIGHT_BOTTOM:
                if (x >= matrixRectF.left && y >= matrixRectF.top) {
                    scaleRate = caculatePointToVertex(x, y, matrixRectF.left, matrixRectF.top) /
                            caculatePointToVertex(x + distanceX, y + distanceY, matrixRectF.left, matrixRectF.top);
                    scaleRate = correctScaleRate(scaleRate);
                    Log.i(TAG, "scaleRate=" + scaleRate);
                    matrix.postScale(scaleRate, scaleRate, matrixRectF.left, matrixRectF.top);
                }
                break;

            default:
                Log.i(TAG, "distanceX=" + distanceX + "distanceY=" + distanceY);
                Log.i(TAG, "left=" + matrixRectF.left + "right=" + matrixRectF.right);
                move(distanceX, distanceY);
        }
        setImageMatrix(matrix);

        //可以省略测的操作
        postInvalidate();
        return true;
    }

    private boolean isPointInTouchRect(float x, float y) {
        Set<Map.Entry<Integer, RectF>> entries = scaleMap.entrySet();
        for (Map.Entry<Integer, RectF> entry : entries) {
            RectF value = entry.getValue();
            if (isPointInRect(x, y, value)) {
                return true;
            }
        }
        return false;
    }

    private void move(float distanceX, float distanceY) {
        //优先保证left不超过
        distanceX = correctXBounds(distanceX);
        //优先保证top不超过
        distanceY = correctYBounds(distanceY);
        matrix.postTranslate(-distanceX, -distanceY);
    }

    private float correctXBounds(float distanceX) {
        RectF matrixRectF = getMatrixRectF();
        distanceX = matrixRectF.right - distanceX > getWidth() ? -getWidth() + matrixRectF.right : distanceX;
        distanceX = matrixRectF.left - distanceX < 0 ? matrixRectF.left : distanceX;
        return distanceX;
    }

    private float correctYBounds(float distanceY) {
        RectF matrixRectF = getMatrixRectF();
        distanceY = matrixRectF.bottom - distanceY > getHeight() ? -getHeight() + matrixRectF.bottom : distanceY;
        distanceY = matrixRectF.top - distanceY < 0 ? matrixRectF.top : distanceY;
        return distanceY;
    }

    private float getRealWidth() {
        RectF matrixRectF = getMatrixRectF();
        return matrixRectF.right - matrixRectF.left;
    }

    private float getRealHeight() {
        RectF matrixRectF = getMatrixRectF();
        return matrixRectF.bottom - matrixRectF.top;
    }

    private float correctScaleRate(float scaleRate) {
        RectF matrixRectF = getMatrixRectF();
        float w = matrixRectF.right - matrixRectF.left;
        float h = matrixRectF.bottom - matrixRectF.top;

        if ((w <= WATERMARK_MIN_WIDTH * 2 || h <= WATERMARK_MIN_WIDTH * 2) && scaleRate <= 1) {
            return 1;
        }

        if (w * scaleRate <= WATERMARK_MIN_WIDTH * 2 || h * scaleRate <= WATERMARK_MIN_WIDTH * 2) {
            return Math.max(WATERMARK_MIN_WIDTH * 2 / w, WATERMARK_MIN_WIDTH * 2 / h);
        }

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

        float w = right - left;
        float h = bottom - top;

        float innerVertical = getTouchAreaInnerAdd(h);
        float horizontal = getTouchAreaInnerAdd(w);

        scaleMap.put(LEFT_TOP, new RectF(left - TOUCH_AREA_OUTER, top - TOUCH_AREA_OUTER, left + horizontal, top + innerVertical));
        scaleMap.put(LEFT_BOTTOM, new RectF(left - TOUCH_AREA_OUTER, bottom - innerVertical, left + horizontal, bottom + TOUCH_AREA_OUTER));
        scaleMap.put(RIGHT_TOP, new RectF(right - horizontal, top - TOUCH_AREA_OUTER, right + TOUCH_AREA_OUTER, top + innerVertical));
        scaleMap.put(RIGHT_BOTTOM, new RectF(right - horizontal, bottom - innerVertical, right + TOUCH_AREA_OUTER, bottom + TOUCH_AREA_OUTER));
    }

    private float getTouchAreaInnerAdd(float wOrh) {
        if (wOrh < 80) {
            return wOrh / 10;
        }
        return wOrh / 3;
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

    private RectF getMatrixRectFWithTouchArea() {
        RectF matrixRectF = getMatrixRectF();
        matrixRectF.left = matrixRectF.left -= TOUCH_AREA_OUTER;
        matrixRectF.top = matrixRectF.top -= TOUCH_AREA_OUTER;
        matrixRectF.right = matrixRectF.right += TOUCH_AREA_OUTER;
        matrixRectF.bottom = matrixRectF.bottom += TOUCH_AREA_OUTER;
        return matrixRectF;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getDrawable() == null) {
            return;
        }
        updateScaleRect();
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
