package com.bilibili.diyviewcomponent.spotlight;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class CircleView extends View {

    Canvas cacheCanvas;
    Bitmap cacheBitmap;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        post(new Runnable() {
            @Override
            public void run() {
                cacheBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                cacheBitmap.eraseColor(Color.parseColor("#cc000000"));
                cacheCanvas = new Canvas(cacheBitmap);
                drawCircle();
            }
        });
    }

    private void drawCircle() {
        Rect rect = new Rect(100, 100, 600, 600);
        RadialGradient r = new RadialGradient(350, 350, 250,
                Color.TRANSPARENT,
                Color.parseColor("#cc000000"),
                Shader.TileMode.CLAMP);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(r);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        cacheCanvas.drawOval(new RectF(rect), paint);
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (cacheCanvas == null) {
            return;
        }
        Paint paint = new Paint();
        canvas.drawBitmap(cacheBitmap, 0, 0, paint);
    }

}
