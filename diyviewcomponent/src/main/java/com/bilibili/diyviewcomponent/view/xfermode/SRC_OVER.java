package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

/**
 * [Sa + (1 - Sa)*Da, Rc = Sc + (1 - Sa)*Dc]
 */
public class SRC_OVER extends BaseView {
    public SRC_OVER(Context context) {
        super(context);
    }

    public SRC_OVER(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SRC_OVER(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);
    }
}
