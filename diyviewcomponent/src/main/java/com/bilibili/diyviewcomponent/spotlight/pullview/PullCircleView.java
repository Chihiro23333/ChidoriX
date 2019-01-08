package com.bilibili.diyviewcomponent.spotlight.pullview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bilibili.diyviewcomponent.R;

public class PullCircleView extends View {

    private Paint mPaint;

    private Bitmap mBitmap;
    private Canvas mCacheCanvas;

    private int mBgColor = Color.BLACK;
    private int mCircleColor = Color.TRANSPARENT;

    private int mRadius = 200;
    private int mCenterX = mRadius / 2, mCenterY = mRadius / 2;

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
        mPaint = new Paint();
        mPaint.setColor(mCircleColor);

        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mBitmap == null) {
            mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            mCacheCanvas = new Canvas(mBitmap);
        }

        mBitmap.eraseColor(mBgColor);
        mCacheCanvas.drawCircle(mRadius, mRadius, mRadius, mPaint);

        canvas.drawBitmap(mBitmap, 0, 0, null);
    }
}
