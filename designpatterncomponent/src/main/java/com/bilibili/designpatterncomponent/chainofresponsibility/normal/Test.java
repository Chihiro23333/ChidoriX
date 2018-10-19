package com.bilibili.designpatterncomponent.chainofresponsibility.normal;

public class Test {
    public static void main(String args[]){
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        Handler handler3 = new ConcreteHandler();

        handler1.setNext(handler2);
        handler2.setNext(handler3);

        handler1.handleRequest();
    }
}
