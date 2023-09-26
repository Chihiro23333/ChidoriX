package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public abstract class BaseView extends View {

    private int width = 400;
    private int height = 400;

    private Paint dstPaint;
    private Paint srcPaint;

    private Paint mPaint;

    public BaseView(Context context) {
        this(context, null);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int layerId = canvas.saveLayer(0, 0, width * 2, height * 2, mPaint, Canvas.ALL_SAVE_FLAG);

        Bitmap dstBmp = makeDst();
        canvas.drawBitmap(dstBmp, 0, 0, mPaint);
        mPaint.setXfermode(getXfermode());
        Bitmap srcBmp = makeSrc();
        canvas.drawBitmap(srcBmp, width / 2, height / 2, mPaint);

        canvas.restoreToCount(layerId);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(width*2, height*2);
    }

    protected abstract Xfermode getXfermode();

    private void initPaint() {
        dstPaint = new Paint();
        dstPaint.setColor(0xFFFFCC44);

        srcPaint = new Paint();
        srcPaint.setColor(0xFF66AAFF);

        mPaint = new Paint();
    }

    private Bitmap makeDst() {
        Bitmap dstBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(dstBmp);

        canvas.drawOval(new RectF(0, 0, width, height), dstPaint);
        return dstBmp;
    }

    private Bitmap makeSrc() {
        Bitmap srcBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(srcBmp);

        canvas.drawRect(0, 0, width, height, srcPaint);
        return srcBmp;
    }
}
