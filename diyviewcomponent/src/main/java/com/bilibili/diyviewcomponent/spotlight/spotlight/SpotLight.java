package com.bilibili.diyviewcomponent.spotlight.spotlight;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class SpotLight extends ViewGroup {

    private static final String TAG = "SpotLightViewGroup";

    public SpotLight(Context context) {
        this(context, null);
    }

    public SpotLight(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpotLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // 计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Log.i(TAG, "width=" + childAt.getMeasuredWidth() + "height=" + childAt.getMeasuredHeight());
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.i(TAG, "l=" + l + "t=" + t + "r=" + r + "b=" + b);

        BaseSpotLightView spotLightView = (BaseSpotLightView) getChildAt(0);
        ILightLocation lightLocation = spotLightView.getLightLocation();
        int lightBottom = lightLocation.getLightBottom();
        int lightLeft = lightLocation.getLightLeft();

        View menu = getChildAt(1);

        spotLightView.layout(l, t, r, b);
        menu.layout(lightLeft, lightBottom, lightLeft + menu.getMeasuredWidth(), lightBottom + menu.getMeasuredHeight());
    }
}
