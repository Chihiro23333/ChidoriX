package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.bilibili.diyviewcomponent.R;


public class CircleProgressView extends View {
    // 画圆环的画笔
    private Paint ringPaint;
    // 画圆环的画笔
    private Paint fullRingPaint;
    // 画字体的画笔
    private Paint textPaint;
    // 圆环颜色
    private int ringColor = Color.RED;
    // 圆环颜色
    private int fullRingColor = Color.BLUE;
    // 字体颜色
    private int textColor = Color.BLACK;
    // 半径
    private int radius;
    // 圆环宽度
    private int strokeWidth;
    // 字的长度
    private float txtWidth;
    // 字的高度
    private float txtHeight;
    // 总进度
    private int totalProgress = 100;
    // 当前进度
    private int currentProgress = 60;
    // 透明度   private int alpha = 25;

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
        initVariable();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typeArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.diyview_CircleProgressView, 0, 0);
        radius = (int) typeArray.getDimension(R.styleable.diyview_CircleProgressView_diyview_cpv_radius, 80);
        strokeWidth = (int) typeArray.getDimension(R.styleable.diyview_CircleProgressView_diyview_cpv_strokeWidth, 10);
//        ringColor = typeArray.getColor(R.styleable.diyview_CircleProgressView_diyview_cpv_ringColor, 0xFF0000);
//        textColor = typeArray.getColor(R.styleable.diyview_CircleProgressView_diyview_cpv_textColor, 0xFFFFFF);
    }

    private void initVariable() {
        ringPaint = new Paint();
        ringPaint.setAntiAlias(true);
        ringPaint.setDither(true);
        ringPaint.setColor(ringColor);
        ringPaint.setStyle(Paint.Style.STROKE);
        ringPaint.setStrokeWidth(strokeWidth);

        fullRingPaint = new Paint();
        fullRingPaint.setAntiAlias(true);
        fullRingPaint.setDither(true);
        fullRingPaint.setColor(fullRingColor);
        fullRingPaint.setStyle(Paint.Style.STROKE);
        fullRingPaint.setStrokeWidth(strokeWidth);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(textColor);
        textPaint.setTextSize(radius / 2);
        Paint.FontMetrics fm = textPaint.getFontMetrics();
        txtHeight = fm.descent + Math.abs(fm.ascent);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measureSpec = MeasureSpec.makeMeasureSpec(radius * 2 + strokeWidth * 2, MeasureSpec.EXACTLY);
        setMeasuredDimension(measureSpec, measureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentProgress >= 0) {
            RectF oval = new RectF(getWidth() / 2 - radius, getHeight() / 2 - radius, getWidth() / 2 + radius, getHeight() / 2 + radius);
            canvas.drawArc(oval, 0, 360, false, fullRingPaint);
            canvas.drawArc(oval, -90, ((float) currentProgress / totalProgress) * 360, false, ringPaint);
            String txt = currentProgress + "%";
            txtWidth = textPaint.measureText(txt, 0, txt.length());
            canvas.drawText(txt, getWidth() / 2 - txtWidth / 2, getHeight() / 2 + txtHeight / 4, textPaint);
        }
    }

    public void setProgress(int progress) {
        currentProgress = progress;
        postInvalidate();
    }
}
