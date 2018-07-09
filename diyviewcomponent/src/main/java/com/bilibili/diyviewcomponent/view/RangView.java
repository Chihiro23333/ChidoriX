package com.bilibili.diyviewcomponent.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RangView extends View {
    public RangView(Context context) {
        this(context ,null);
    }

    public RangView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public RangView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
