package com.bilibili.diyviewcomponent.spotlight.spotlight;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public abstract class BaseSpotLightView extends View {

    //四个角的圆绘制边界
    protected int[] moveMargin = new int[]{0, 0, 0, 0};

    public BaseSpotLightView(Context context) {
        super(context);
    }

    public BaseSpotLightView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseSpotLightView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setMoveMargin(int[] moveMargin) {
        this.moveMargin = moveMargin;
    }

    public abstract ILightLocation getLightLocation();
}
