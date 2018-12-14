package com.bilibili.diyviewcomponent.spotlight.spotlight;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import wkb.core2.export.Wkb;

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

    public void updatePPTSpotLightShowArea() {
        int canvasContainerHeight = Wkb.getCanvasContainerHeight();
        int canvasContainerWidth = Wkb.getCanvasContainerWidth();
        int screenHeight = Wkb.getScreenHeight();
        int screenWidth = Wkb.getScreenWidth();
        int hGap = screenHeight - canvasContainerHeight;
        int wGap = screenWidth - canvasContainerWidth;
        setMoveMargin(new int[]{wGap / 2, hGap / 2, wGap / 2, hGap / 2});
    }

    public void setMoveMargin(int[] moveMargin) {
        this.moveMargin = moveMargin;
    }

    public abstract ILightLocation getLightLocation();
}
