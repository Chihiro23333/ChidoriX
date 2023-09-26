package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

/**
 * [0, 0]
 */
public class CLEAR extends BaseView {
    public CLEAR(Context context) {
        super(context);
    }

    public CLEAR(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CLEAR(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    }
}
