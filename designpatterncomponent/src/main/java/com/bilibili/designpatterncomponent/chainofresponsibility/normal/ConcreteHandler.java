package com.bilibili.designpatterncomponent.chainofresponsibility.normal;

public class ConcreteHandler extends Handler {
    @Override
    public void handleRequest() {
        if (getNext() != null) {
            System.out.println("交给下一个处理");
            getNext().handleRequest();
        } else {
            System.out.println("没有下一个直接处理");
        }
    }
}
