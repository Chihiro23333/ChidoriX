package com.bilibili.designpatterncomponent.strategy;

public class FlyWithWings implements IFlyBehavior {
    @Override
    public void fly() {
        System.out.println("用翅膀飞行");
    }
}
