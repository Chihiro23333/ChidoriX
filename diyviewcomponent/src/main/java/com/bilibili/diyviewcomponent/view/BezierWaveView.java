package com.bilibili.diyviewcomponent.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by Chihiro on 2018/7/19.
 */

public class BezierWaveView extends View {

    private Paint mPaint;
    private Path mPath;
    private int waveLegth = 400;
    private int dx;

    public BezierWaveView(Context context) {
        this(context, null);
    }

    public BezierWaveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierWaveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);

        mPath = new Path();

        startAnim();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.reset();
        mPath.moveTo(-waveLegth + dx, 600);

        for (int i = -waveLegth; i < getWidth() + waveLegth; i += waveLegth) {
            mPath.rQuadTo(waveLegth / 4, 200, waveLegth/2, 0);
            mPath.rQuadTo(waveLegth / 4, -200, waveLegth/2, 0);
        }

        canvas.drawPath(mPath, mPaint);
    }

    private void startAnim() {
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(0, waveLegth);
        valueAnimator.setDuration(2000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                dx = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();
    }
}
