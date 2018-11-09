package com.bilibili.designpatterncomponent.chainofresponsibility.view;

import java.util.List;

public abstract class ViewGroup extends View {

    private List<View> children;


    public ViewGroup(List<View> children) {
        this.children = children;
    }

    protected boolean onTouchEvent() {
        return false;
    }

    protected boolean dispatchTouchEvent() {
        if(onInterceptTouchEvent()){
            onTouchEvent();
        }else {
            for (int i = 0; i < children.size(); i++) {
                View view = children.get(i);
                if(view.dispatchTouchEvent()){
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean onInterceptTouchEvent() {
        return false;
    }

}
