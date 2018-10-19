package com.bilibili.designpatterncomponent.chainofresponsibility.normal;

public abstract class Handler {

    private Handler next;


    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest();
}
