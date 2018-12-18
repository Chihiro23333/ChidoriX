package com.bilibili.diyviewcomponent.spotlight.spotlight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PullCircleView extends View {

    private Paint mCirclePaint;
    private Paint mControlPaint;
    private Paint mBgPaint;

    private int mBgColor = Color.BLACK;
    private int mControlColor = Color.BLUE;

    private Bitmap mBgBmp;

    private int mRadius = 500;

    public PullCircleView(Context context) {
        this(context, null);
    }

    public PullCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PullCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mBgPaint = new Paint();
        mBgPaint.setColor(mBgColor);

        mCirclePaint = new Paint();
        mCirclePaint.setColor(Color.TRANSPARENT);

        mControlPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mBgBmp == null) {
            mBgBmp = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas1 = new Canvas(mBgBmp);
            canvas1.drawRect(new Rect(0,0,getWidth(),getHeight()) ,mBgPaint);
        }

        mBgPaint.setShader(new BitmapShader(mBgBmp, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
        canvas.drawCircle(mRadius, mRadius, mRadius, mBgPaint);
    }
}
