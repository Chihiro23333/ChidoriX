package com.bilibili.diyviewcomponent.view.xfermode;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class XOR extends BaseView {
    public XOR(Context context) {
        super(context);
    }

    public XOR(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public XOR(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected Xfermode getXfermode() {
        return new PorterDuffXfermode(PorterDuff.Mode.XOR);
    }
}
