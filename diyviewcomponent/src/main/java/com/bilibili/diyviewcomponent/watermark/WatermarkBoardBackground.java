package com.bilibili.diyviewcomponent.watermark;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 朱峰 2019/6/3
 */
public class WatermarkBoardBackground extends View {

    private static final int LINE_NUM = 10;
    private Paint linePaint;

    public WatermarkBoardBackground(Context context) {
        this(context, null);
    }

    public WatermarkBoardBackground(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WatermarkBoardBackground(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
        initPaint();
    }

    private void initPaint() {
        linePaint = new Paint();
        linePaint.setColor(Color.parseColor("#dddddd"));
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画横线
        float startY = linePaint.getStrokeWidth()/2;
        float lineHeight = getHeight() * 1f / LINE_NUM;
        for (; startY < getHeight();) {
            canvas.drawLine(0, startY, getWidth(), startY, linePaint);
            startY += lineHeight;
        }
        //画竖线
        float startX = linePaint.getStrokeWidth()/2;
        for (; startX < getWidth();) {
            canvas.drawLine(startX, 0, startX, getHeight(), linePaint);
            startX += lineHeight;
        }
    }
}
