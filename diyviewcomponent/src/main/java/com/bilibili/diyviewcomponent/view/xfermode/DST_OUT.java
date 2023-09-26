package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

/**
 * [Da * (1 - Sa), Dc * (1 - Sa)]
 */
public class DST_OUT extends BaseView {
    public DST_OUT(Context context) {
        super(context);
    }

    public DST_OUT(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DST_OUT(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }
}
