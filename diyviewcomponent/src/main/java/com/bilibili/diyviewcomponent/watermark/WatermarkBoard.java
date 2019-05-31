package com.bilibili.diyviewcomponent.watermark;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

    public WatermarkBoard(@NonNull Context context) {
        this(context, null);
    }

    public WatermarkBoard(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WatermarkBoard(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDefault(context);
    }

    private void initDefault(Context context) {
        setBackgroundColor(context.getResources().getColor(R.color.common_colorAccent));
    }

    public void addWatermark(EditableWatermark watermark){
        this.watermark = watermark;
        removeAllViews();
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.RIGHT;
        addView((View) watermark, layoutParams);
    }

    public EditableWatermark getWatermark() {
        return watermark;
    }
}
