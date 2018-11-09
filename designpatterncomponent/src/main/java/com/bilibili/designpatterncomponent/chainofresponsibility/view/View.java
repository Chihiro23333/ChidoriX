package com.bilibili.designpatterncomponent.chainofresponsibility.view;

public abstract class View {
    protected boolean onTouchEvent() {
        return false;
    }

    protected boolean dispatchTouchEvent() {
        return onTouchEvent();
    }
}
