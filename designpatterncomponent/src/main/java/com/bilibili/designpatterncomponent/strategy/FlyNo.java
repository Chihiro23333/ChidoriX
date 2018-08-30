package com.bilibili.designpatterncomponent.strategy;

public class FlyNo implements IFlyBehavior {
    @Override
    public void fly() {
        System.out.println("不能飞行");
    }
}
