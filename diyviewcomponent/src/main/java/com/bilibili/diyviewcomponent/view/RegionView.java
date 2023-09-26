package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RegionView extends View {

    private Paint mPaint;

    public RegionView(Context context) {
        this(context, null);
    }

    public RegionView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RegionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //普通区域
//        Region region = new Region(100, 100, 400, 400);
//
//        RegionIterator regionIterator = new RegionIterator(region);
//        Rect rect = new Rect();
//        while (regionIterator.next(rect)) {
//            canvas.drawRect(rect, mPaint);
//        }

        //椭圆形区域
        Path ovalPath = new Path();
        RectF ovalRectF = new RectF(100, 500, 300, 700);
        ovalPath.addOval(ovalRectF, Path.Direction.CCW);

        Region region1 = new Region();
        region1.setPath(ovalPath, new Region(100, 600, 300, 700));
        RegionIterator regionIterator1 = new RegionIterator(region1);

        Rect rect1 = new Rect();
        while (regionIterator1.next(rect1)) {
            canvas.drawRect(rect1 ,mPaint);
        }
    }
}
