package com.bilibili.designpatterncomponent.strategy;

public class RedHeadDuck  extends Duck {

    public RedHeadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new GuaGuaQuack();
    }

    @Override
    public void display() {
        System.out.println("红头鸭子");
    }
}
