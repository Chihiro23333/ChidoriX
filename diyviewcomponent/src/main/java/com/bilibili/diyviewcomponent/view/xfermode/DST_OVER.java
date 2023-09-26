package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

/**
 * [Sa + (1 - Sa)*Da, Rc = Dc + (1 - Da)*Sc]
 */
public class DST_OVER extends BaseView{
    public DST_OVER(Context context) {
        super(context);
    }

    public DST_OVER(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DST_OVER(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);
    }
}
