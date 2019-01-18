package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * [Da * Sa,Dc * Sa]
 */
public class DST_IN extends BaseView {
    public DST_IN(Context context) {
        super(context);
    }

    public DST_IN(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DST_IN(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
}
