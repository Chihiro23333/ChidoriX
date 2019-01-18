package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Saturate(S + D)
 */

public class ADD extends BaseView {

    public ADD(Context context) {
        super(context);
    }

    public ADD(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ADD(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.ADD);
    }
}
