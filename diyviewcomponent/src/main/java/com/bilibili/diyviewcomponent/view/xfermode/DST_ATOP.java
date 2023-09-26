package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

/**
 * [Sa, Sa * Dc + Sc * (1 - Da)]
 */
public class DST_ATOP extends BaseView {
    public DST_ATOP(Context context) {
        super(context);
    }

    public DST_ATOP(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DST_ATOP(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
    }
}
