package com.bilibili.diyviewcomponent.watermark;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bilibili.diyviewcomponent.R;

import java.net.PortUnreachableException;


/**
 * @author 朱峰 2019/5/29
 */
public class WatermarkBoard extends FrameLayout {

    private static final String TAG = "WatermarkBoard";

    private EditableWatermark watermark;

    private WatermarkBitmapView bitmapView;

    public WatermarkBoard(@NonNull Context context) {
        this(context, null);
    }

    public WatermarkBoard(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WatermarkBoard(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        addWatermarkBitmapView(context);
    }

    private void addWatermarkBitmapView(Context context) {
        bitmapView = new WatermarkBitmapView(getContext());
        addView(bitmapView);
        bitmapView.setVisibility(INVISIBLE);
    }

    public Bitmap getAlphaBitmap() {
        Bitmap bitmap = null;
        if (bitmapView != null) {
            Bitmap wa = watermark.getBitmap();
            if (wa != null) {
                bitmapView.updateBitmapAndAlpha(wa, (int) (watermark.getWatermarkAlpha() * 255));
                bitmapView.setDrawingCacheEnabled(true);
                Bitmap drawingCache = bitmapView.getDrawingCache();
                if (drawingCache != null) {
                    bitmap = Bitmap.createBitmap(drawingCache, 0, 0, wa.getWidth(), wa.getHeight());
                }
                bitmapView.setDrawingCacheEnabled(false);
            }
        }
        return bitmap;
    }

    public void addBackground(View view) {
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(view, 0, layoutParams);
    }

    public void addWatermark(EditableWatermark watermark) {
        this.watermark = watermark;
        if (getChildCount() > 2) {
            removeViewAt(2);
        }
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.RIGHT;
        addView((View) watermark, layoutParams);
    }

    public EditableWatermark getWatermark() {
        return watermark;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        float rate = hSize * 1f / wSize;
        if (rate > 3f / 4) {
            hSize = wSize * 3 / 4;
        } else {
            wSize = hSize * 4 / 3;
        }
        int wm = MeasureSpec.makeMeasureSpec(wSize, MeasureSpec.EXACTLY);
        int hm = MeasureSpec.makeMeasureSpec(hSize, MeasureSpec.EXACTLY);
        super.onMeasure(wm, hm);
    }
}
