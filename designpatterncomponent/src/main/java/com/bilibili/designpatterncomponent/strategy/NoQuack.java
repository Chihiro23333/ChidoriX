package com.bilibili.designpatterncomponent.strategy;

public class NoQuack implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("不会叫");
    }
}
