package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class BezierMoveActionView extends View {

    private Paint mPaint;

    public BezierMoveActionView(Context context) {
        this(context, null);
    }

    public BezierMoveActionView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public BezierMoveActionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();

    }
}
