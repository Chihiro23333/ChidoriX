package com.bilibili.diyviewcomponent.watermark;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author 朱峰 2019/6/6
 */
public class WatermarkBitmapView extends View {

    private Paint paint;

    private Bitmap bitmap;

    public WatermarkBitmapView(Context context) {
        this(context, null);
    }

    public WatermarkBitmapView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WatermarkBitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
    }

    public void updateBitmapAndAlpha(Bitmap bitmap, int alpha) {
        this.bitmap = bitmap;
        paint.setAlpha(alpha);
        postInvalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i("###","onMeasure");
        if(bitmap != null){
            int w = MeasureSpec.makeMeasureSpec(bitmap.getWidth(), MeasureSpec.EXACTLY);
            int h = MeasureSpec.makeMeasureSpec(bitmap.getHeight(), MeasureSpec.EXACTLY);
            setMeasuredDimension(w, h);
        }else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i("###","onDraw");
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0, 0, paint);
        }
    }

}
