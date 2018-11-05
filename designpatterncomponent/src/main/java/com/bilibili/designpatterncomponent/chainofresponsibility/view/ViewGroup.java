package com.bilibili.designpatterncomponent.chainofresponsibility.view;

import java.util.List;

public abstract class ViewGroup extends View {

    private List<View> children;


    public ViewGroup(List<View> children) {
        this.children = children;
    }

    protected boolean onInterceptTouchEvent() {
        return false;
    }

}
