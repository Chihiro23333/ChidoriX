package com.bilibili.diyviewcomponent.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Chihiro on 2018/7/29.
 */

public class RefreshHeaderLayout extends ViewGroup {
    public RefreshHeaderLayout(Context context) {
        this(context ,null);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attrs) {
        this(context, attrs ,0);
    }

    public RefreshHeaderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * LayoutParams of RefreshHeaderLayout
     */
    public static class LayoutParams extends MarginLayoutParams {

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.MATCH_PARENT ,LayoutParams.MATCH_PARENT);
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new ViewGroup.LayoutParams(p);
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext() ,attrs);
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        layoutChildren();
    }

    private void layoutChildren() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        int height = getMeasuredHeight();

        int childCount = getChildCount();

        if(childCount >0){
            View childAt = getChildAt(0);
            int childMeasuredWidth = childAt.getMeasuredWidth();
            int childMeasuredHeight = childAt.getMeasuredHeight();

            MarginLayoutParams layoutParams = (MarginLayoutParams) childAt.getLayoutParams();

            int childLeft = paddingLeft +layoutParams.leftMargin;
            int childTop = paddingTop +layoutParams.topMargin;
            int childRight =childLeft + childMeasuredWidth;
            int childBottom = childTop + childMeasuredHeight;

            childAt.layout(childLeft ,childTop ,childRight ,childBottom);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
            View view = getChildAt(0);
            measureChildWithMargins(view, widthMeasureSpec, 0, heightMeasureSpec, 0);
            setMeasuredDimension(view.getMeasuredWidth() ,view.getMeasuredHeight());
        }else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
