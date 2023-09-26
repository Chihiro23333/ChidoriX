package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

/**
 * [Da, Sc * Da + (1 - Sa) * Dc]
 */
public class SRC_ATOP extends BaseView {
    public SRC_ATOP(Context context) {
        super(context);
    }

    public SRC_ATOP(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SRC_ATOP(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    }
}
