package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Chihiro on 2018/7/25.
 */

public class ColorFilterView extends View {

    private Paint mPaint;

    public ColorFilterView(Context context) {
        this(context ,null);
    }

    public ColorFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public ColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();

    }

    private void initPaint() {

    }
}
