package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bilibili.diyviewcomponent.R;

/**
 * Created by Chihiro on 2018/7/29.
 */

public class XferModeView extends View {

    private int width = 200;
    private int height = 200;

    private Paint mPaint;
    private Bitmap bitmap;

    public XferModeView(Context context) {
        this(context ,null);
    }

    public XferModeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public XferModeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
    }


    //这里还需要强调一点，源图像在运算时，只是在源图像所在区域与对应区域的目标图像做运算。
    // 所以目标图像与源图像不相交的地方是不会参与运算的！这一点非常重要！不相交的地方不会参与运算，
    // 所以不相交的地方的图像也不会是脏数据，也不会被更新，所以不相交地方的图像也永远显示的是目标图像。

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap dstBitmap = drawDst();
        Bitmap srcBitmap = drawSrc();

        canvas.drawColor(Color.GRAY);

        int layerId = canvas.saveLayer(0, 0, width * 2, height * 2, mPaint ,Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(dstBitmap , 0 ,0 ,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(srcBitmap ,width/2 ,height/2 ,mPaint);
        mPaint.setXfermode(null);

        canvas.restoreToCount(layerId);

    }

    private Bitmap drawSrc() {
        Bitmap bitmap = Bitmap.createBitmap(width ,height ,Bitmap.Config.ARGB_8888);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawRect(new Rect(0,0,width,height) ,paint);

        return bitmap;
    }

    private Bitmap drawDst() {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawOval(new RectF(0 ,0 ,width ,height ) ,paint);

        return bitmap;
    }
}
