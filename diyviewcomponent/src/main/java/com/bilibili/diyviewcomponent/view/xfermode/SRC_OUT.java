package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

/**
 * [Sa * (1 - Da), Sc * (1 - Da)]
 */
public class SRC_OUT extends BaseView {
    public SRC_OUT(Context context) {
        super(context);
    }

    public SRC_OUT(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SRC_OUT(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
    }
}
