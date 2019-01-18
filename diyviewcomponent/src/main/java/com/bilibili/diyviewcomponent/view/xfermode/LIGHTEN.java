package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * [Sa + Da - Sa*Da,Sc*(1 - Da) + Dc*(1 - Sa) + max(Sc, Dc)]
 */
public class LIGHTEN extends BaseView{
    public LIGHTEN(Context context) {
        super(context);
    }

    public LIGHTEN(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LIGHTEN(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN);
    }
}
