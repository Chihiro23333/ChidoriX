package com.bilibili.designpatterncomponent.chainofresponsibility.sample;

public abstract class Handler {
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handRequest(double fee ,String name);
}
