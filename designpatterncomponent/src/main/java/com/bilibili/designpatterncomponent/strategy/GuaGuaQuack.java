package com.bilibili.designpatterncomponent.strategy;

public class GuaGuaQuack implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
