package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

/**
 * [Sa * Da, Sc * Da]
 */
public class SRC_IN extends BaseView {
    public SRC_IN(Context context) {
        super(context);
    }

    public SRC_IN(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SRC_IN(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    }
}
